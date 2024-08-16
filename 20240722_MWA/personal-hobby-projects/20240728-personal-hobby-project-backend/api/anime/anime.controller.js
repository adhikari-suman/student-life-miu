const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const sendResponse = require("../../utils/send_response");
const AnimeModel = mongoose.model(process.env.MONGODB_ANIME_MODEL_NAME);

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

const _setResponseToAnimeWithPaginationData = (response, anime, paginationData) => {
    response.status = parseInt(process.env.HTTP_STATUS_OK);
    response.data = {
        anime: anime,
        pagination: paginationData,
    };
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

const _setPaginationData = function (paginationData, page, size, count) {
    return new Promise((resolve) => {
        const offset = (page - 1) * size;

        paginationData.page = page;
        paginationData.size = size;
        paginationData.total = count;
        paginationData.hasNext = (offset + size) < count;
        paginationData.hasPrevious = page > 1;

        resolve(paginationData);
    });
}


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
        const paginationData = {
            page: page,
            size: size,
            total: 0,
            hasNext: false,
            hasPrevious: page > 1,
        };

        AnimeModel.find().countDocuments().exec()
            .then(count => _setPaginationData(paginationData, page, size, count))
            .then(() => AnimeModel.find().skip(offset).limit(size).exec())
            .then(anime => _setResponseToAnimeWithPaginationData(response, anime, paginationData))
            .catch(error => _setResponseToError(response, error))
            .finally(() => {

                console.log(paginationData);
                sendResponse(res, response);
            });
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

const _updateAnimeFull = (anime, update) => {
    return new Promise((resolve, reject) => {
        anime.name = update.name;
        anime.releaseDate = update.releaseDate;
        anime.studio = update.studio;
        anime.characters = update.characters;

        resolve(anime);
    });
};

const _updateAnimePartial = (anime, update) => {
    return new Promise((resolve, reject) => {
        console.log(update);

        if (update.name) {
            anime.name = update.name;
        }
        if (update.releaseDate) {
            anime.releaseDate = update.releaseDate;
        }
        if (update.studio) {
            anime.studio = update.studio;
        }
        if (update.characters) {
            anime.characters = update.characters;
        }

        resolve(anime);
    });
};

const _updateOne = function (req, res, updateAnimeFunction) {
    const animeId = req.params.id;

    const update = {
        name: req.body.name,
        releaseDate: req.body.releaseDate,
        studio: req.body.studio,
        characters: req.body.characters
    }

    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    AnimeModel.findById(animeId).exec()
        .then(anime => _doesAnimeExist(anime))
        .then(anime => updateAnimeFunction(anime, update))
        .then((anime) => anime.save())
        .then(anime => _setResponseToAnime(response, anime))
        .catch(error => _setResponseToError(response, error))
        .finally(() => sendResponse(res, response));
}

const fullUpdateOne = function (req, res) {
    _updateOne(req, res, _updateAnimeFull);
};

const partiallyUpdateOne = function (req, res) {
    _updateOne(req, res, _updateAnimePartial);
};

const _setResponseToDeleteAnimeSuccess = (response) => {
    response.status = parseInt(process.env.HTTP_STATUS_NO_CONTENT)
    response.data = null;
};

const _setResponseToDeleteAnimeFailed = (response, error) => {
    response.status = parseInt(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR)
    response.data = error;
};

const deleteOne = function (req, res) {
    const animeId = req.params.id;

    const response = {
        status: parseInt(process.env.HTTP_STATUS_NO_CONTENT),
        data: null,
    }

    if (animeId === null || animeId === undefined || !ObjectId.isValid(animeId)) {
        response.status = parseInt(process.env.HTTP_STATUS_BAD_REQUEST)
        response.data = process.env.ERROR_RESPONSE_INVALID_OBJECT_ID;

        sendResponse(res, response);
    } else {
        const filter = {_id: new ObjectId(animeId)};

        AnimeModel.deleteOne(filter).exec()
            .then(() => _setResponseToDeleteAnimeSuccess(response))
            .catch(error => _setResponseToDeleteAnimeFailed(response, error))
            .finally(() => sendResponse(res, response));
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
