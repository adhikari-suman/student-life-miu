const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const sendResponse = require("../../utils/send_response");
const {parse} = require("dotenv");
const callbackify = require("util").callbackify;
const AnimeModel = mongoose.model(process.env.MONGODB_ANIME_MODEL_NAME);

const HTTP_STATUS_OK = parseInt(process.env.HTTP_STATUS_OK)
const HTTP_STATUS_BAD_REQUEST = parseInt(process.env.HTTP_STATUS_BAD_REQUEST)
const HTTP_STATUS_NOT_FOUND = parseInt(process.env.HTTP_STATUS_NOT_FOUND)
const HTTP_STATUS_INTERNAL_SERVER_ERROR = parseInt(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR)

const anime_findAllPaginated = function (page, size) {
    let offset = (page - 1) * size;

    return AnimeModel.find().skip(offset).limit(size).exec();
};

const anime_findById = function (animeId) {
    return AnimeModel.findById(animeId);
};

const anime_addOne = function (anime) {
    return AnimeModel.create(anime);
};

const anime_saveOne = function (anime) {
    return anime.save();
};

const anime_updateOne = function (animeId, anime) {
    const filter = {_id: new ObjectId(animeId)};
    const change = {$set: anime};

    return AnimeModel.updateOne(filter, change);
};

const anime_deleteOne = function (animeId) {
    const filter = {_id: new ObjectId(animeId)};

    return AnimeModel.deleteOne(filter);
};

const anime_findAllPaginatedWithCallback = callbackify(anime_findAllPaginated);
const anime_findByIdWithCallback = callbackify(anime_findById);
const anime_createWithCallback = callbackify(anime_addOne);
const anime_saveOneWithCallback = callbackify(anime_saveOne);
const anime_updateOneWithCallback = callbackify(anime_updateOne);
const anime_partiallyUpdateOneWithCallback = callbackify(anime_updateOne);
const anime_deleteOneWithCallback = callbackify(anime_deleteOne);

const anime_fullUpdateOne_onFindByIdWithCallback_HandleResponse = function (req, res) {
    const anime_fullUpdateOne_onFindByIdWithCallback_HandleResponseHandler = function (error, anime) {
        const response = {
            status: HTTP_STATUS_OK,
            data: null,
        }

        const anime_saveOneWithCallback_HandleResponse = function (err, anime) {
            if (error) {
                response.status = HTTP_STATUS_INTERNAL_SERVER_ERROR;
                response.data = {
                    error: process.env.ERROR_RESPONSE_INTERNAL_SERVER_ERROR,
                };
            } else {
                response.status = HTTP_STATUS_OK;
                response.data = anime;

                console.log(response);
            }

            sendResponse(res, response);
        };

        if (error) {
            response.status = HTTP_STATUS_INTERNAL_SERVER_ERROR;
            response.data = {
                error: process.env.ERROR_RESPONSE_INTERNAL_SERVER_ERROR,
            };

            sendResponse(res, response);
        } else {
            if (anime != null) {
                anime.name = req.body.name;
                anime.releaseDate = req.body.releaseDate;
                anime.studio = req.body.studio;
                anime.characters = req.body.characters;

                anime_saveOneWithCallback(anime, anime_saveOneWithCallback_HandleResponse);
            } else {
                response.status = HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
                }

                sendResponse(res, response);
            }
        }
    }

    return anime_fullUpdateOne_onFindByIdWithCallback_HandleResponseHandler;
}

const anime_partialUpdateOne_onFindByIdWithCallback_HandleResponse = function (req, res) {
    const anime_partialUpdateOne_onFindByIdWithCallback_HandleResponseHandler = function (error, anime) {
        const response = {
            status: HTTP_STATUS_OK,
            data: null,
        }

        const anime_saveOneWithCallback_HandleResponse = function (err, anime) {
            if (error) {
                response.status = HTTP_STATUS_INTERNAL_SERVER_ERROR;
                response.data = {
                    error: process.env.ERROR_RESPONSE_INTERNAL_SERVER_ERROR,
                };
            } else {
                response.status = HTTP_STATUS_OK;
                response.data = anime;
            }

            sendResponse(res, response);
        };

        if (error) {
            response.status = HTTP_STATUS_INTERNAL_SERVER_ERROR;
            response.data = {
                error: process.env.ERROR_RESPONSE_INTERNAL_SERVER_ERROR,
            };

            sendResponse(res, response);
        } else {
            if (anime != null) {
                if (req.body.name) {
                    anime.name = req.body.name;
                }

                if (req.body.releaseDate) {
                    anime.releaseDate = req.body.releaseDate;
                }

                if (req.body.studio) {
                    anime.studio = req.body.studio;
                }

                if (req.body.characters) {
                    anime.characters = req.body.characters;
                }

                anime_saveOneWithCallback(anime, anime_saveOneWithCallback_HandleResponse);
            } else {
                response.status = HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
                }

                sendResponse(res, response);
            }
        }
    }

    return anime_partialUpdateOne_onFindByIdWithCallback_HandleResponseHandler;
}

const anime_onMongooseResponseCallback = function (res) {
    const responseHandler = function (error, anime) {
        if (error) {
            res.status(HTTP_STATUS_INTERNAL_SERVER_ERROR).json({
                error: process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG,
            });
        } else {
            if (anime == null) {
                res.status(HTTP_STATUS_NOT_FOUND).json({
                    error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
                });
            } else {
                res.status(HTTP_STATUS_OK).json(anime);
            }
        }
    };

    return responseHandler;
};

const _doesAnimeExist = anime => {
    return new Promise((resolve, reject) => {
        if (!anime) {
            const error = {
                status: parseInt(process.env.HTTP_STATUS_NOT_FOUND),
                data: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }

            reject(error);
        } else {
            resolve(anime);
        }

    });
};

const _setResponseToError = (response, error) => {
    response.status = error.status;
    response.error = error.data;
};

const _setResponseToAnime = (response, anime) => {
    response.status = parseInt(process.env.HTTP_STATUS_OK);
    response.data = anime;
};

const findOne = function (req, res) {
    const animeId = req.params.id;

    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    if (animeId === null || animeId === undefined || !ObjectId.isValid(animeId)) {
        response.status = parseInt(process.env.HTTP_STATUS_BAD_REQUEST)
        response.data = process.env.ERROR_RESPONSE_INVALID_OBJECT_ID;

        sendResponse(res, response);
    } else {
        AnimeModel.findById(animeId).exec()
            .then(anime => _doesAnimeExist(anime))
            .then(anime => _setResponseToAnime(response, anime))
            .catch(error => _setResponseToError(response, error))
            .finally(() => sendResponse(res, response));
    }
};

const findAllWithPagination = function (req, res) {
    let page = parseInt(process.env.QUERY_PAGE_DEFAULT);
    let size = parseInt(process.env.QUERY_SIZE_DEFAULT);
    const maxSize = parseInt(process.env.QUERY_MAX_SIZE_DEFAULT);

    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    if (req.query && req.query.page) {
        page = parseInt(req.query.page);
    }

    if (req.query && req.query.size) {
        size = parseInt(req.query.size);
    }

    if (isNaN(page) || isNaN(size) || page < 1 || size < 1 || size > maxSize) {
        response.status = parseInt(process.env.HTTP_STATUS_BAD_REQUEST)
        response.data = getPageAndMaxSizeErrorMessage(maxSize);

        sendResponse(res, response);
    } else {
        const offset = (page - 1) * size;

        AnimeModel.find().skip(offset).limit(size).exec()
            .then(anime => _setResponseToAnime(response, anime))
            .catch(error => _setResponseToError(response, error))
            .finally(() => sendResponse(res, response));
    }
};

const _setResponseToAnimeCreated = (response, animeCreated) => {
    response.status = parseInt(process.env.HTTP_STATUS_CREATED);
    response.data = animeCreated;
};

const _setResponseToAnimeCreateFailedError = (response, error) => {
    response.status = parseInt(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR);
    response.data = error;
};
const addOne = function (req, res) {
    const httpStatusCreated = parseInt(process.env.HTTP_STATUS_CREATED);

    const response = {
        status: httpStatusCreated,
        data: null,
    }

    if (!req.body) {
        response.status = parseInt(process.env.HTTP_STATUS_BAD_REQUEST);
        response.data = process.env.ERROR_RESPONSE_EMPTY_REQUEST_BODY;

        sendResponse(res, response);
        return;
    }

    const newAnime = {
        name: req.body.name,
        releaseDate: req.body.releaseDate,
        studio: req.body.studio,
        characters: req.body.characters,
    };

    AnimeModel.create(newAnime)
        .then(animeCreated => _setResponseToAnimeCreated(response, animeCreated))
        .catch(error => _setResponseToAnimeCreateFailedError(response, error))
        .finally(() => sendResponse(res, response));
};

const fullUpdateOne = function (req, res) {
    anime_findByIdWithCallback(req.params.id, anime_fullUpdateOne_onFindByIdWithCallback_HandleResponse(req, res));
};

const partiallyUpdateOne = function (req, res) {
    anime_findByIdWithCallback(req.params.id, anime_partialUpdateOne_onFindByIdWithCallback_HandleResponse(req, res));
};

const deleteOne = function (req, res) {
    if (req.params && req.params.id) {
        let animeId = req.params.id;

        if (!ObjectId.isValid(animeId)) {
            res.status(HTTP_STATUS_BAD_REQUEST).json({
                error: process.env.ERROR_RESPONSE_INVALID_OBJECT_ID,
            });
            return;
        }

        anime_deleteOneWithCallback(animeId, anime_onMongooseResponseCallback(res));
    } else {
        res.status(HTTP_STATUS_BAD_REQUEST).json({
            error: process.env.ERROR_RESPONSE_ID_REQUIRED,
        });
    }
};

const getPageAndMaxSizeErrorMessage = function (maxSize) {
    return `${process.env.ERROR_RESPONSE_INVALID_PAGE_AND_SIZE_PARAMS} ${maxSize}.`
}

module.exports = {
    findOne,
    findAllWithPagination,
    addOne,
    fullUpdateOne,
    partiallyUpdateOne,
    deleteOne,
};
