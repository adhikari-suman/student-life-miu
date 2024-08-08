const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const callbackify = require("util").callbackify;
const sendResponse = require('../utils/send_response');
const Anime = mongoose.model(process.env.MONGODB_ANIME_MODEL_NAME);
const characterDocumentName =
    process.env.MONGODB_ANIME_CHARACTERS_DOCUMENT_NAME;

const Anime_findById = function (animeId) {
    return Anime.findById(animeId).exec();
}

const character_onMongooseFindOneResponseCallback = function (
    req,
    res,
    characterId
) {
    return function (error, anime) {
        if (error) {
            console.log(error);
            res.status(500).json({error: "Something went wrong."});
        } else {
            let character = anime.characters.id(characterId);

            if (character == null) {
                res.status(404).json({error: "Character not found."});
            } else {
                res.status(200).json(character);
            }
        }
    };
};

const findAll = function (req, res) {
    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    const animeId = req.params.id;

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }
        } else {
            response.status = process.env.HTTP_STATUS_OK;
            response.data = anime.characters;
        }
    }).catch((error) => {
        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
    }).finally(() => {
        sendResponse(res, response);
    });

};

const findOne = function (req, res) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }
        } else {
            const character = anime.characters.id(characterId);

            if (character === null) {
                response.status = process.env.HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
                };
            } else {
                response.status = process.env.HTTP_STATUS_OK;
                response.data = character;
            }
        }
    }).catch((error) => {
        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
    }).finally(() => {
        sendResponse(res, response);
    });
};


const addOne = function (req, res) {
    const animeId = req.params.id;

    const character = {
        name: req.body.name,
        characteristics: req.body.characteristics,
    }

    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }

            sendResponse(res, response);
        } else {

            anime.characters.push(character)

            anime.save().then(
                (newAnime) => {
                    response.status = process.env.HTTP_STATUS_NO_CONTENT;
                    response.data = anime;
                }
            ).catch(error => {
                response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
                response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
            }).finally(() => {
                sendResponse(res, response);
            });

        }
    }).catch((error) => {
        console.log(error);

        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;

        sendResponse(res, response);
    });
};

const updateOne = function (req, res) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }

            sendResponse(res, response);
        } else {
            const character = anime.characters.id(characterId);

            if (character === null) {
                response.status = process.env.HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
                };

                sendResponse(res, response);
            } else {

                character.name = req.body.name;
                character.characteristics = req.body.characteristics;

                anime.save().then(
                    (newAnime) => {
                        response.status = process.env.HTTP_STATUS_OK;
                        response.data = character;
                    }
                ).catch(error => {
                    response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
                    response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
                }).finally(() => {
                    sendResponse(res, response);
                });
            }
        }
    }).catch((error) => {
        console.log(error);

        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;

        sendResponse(res, response);
    });
};

const partiallyUpdateOne = function (req, res) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }

            sendResponse(res, response);
        } else {
            const character = anime.characters.id(characterId);

            if (character === null) {
                response.status = process.env.HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
                };

                sendResponse(res, response);
            } else {

                if (req && req.body.name) {
                    character.name = req.body.name;
                }
                if (req && req.body.characteristics) {
                    character.characteristics = req.body.characteristics;
                }
                
                anime.save().then(
                    (newAnime) => {
                        response.status = process.env.HTTP_STATUS_OK;
                        response.data = character;
                    }
                ).catch(error => {
                    response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
                    response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
                }).finally(() => {
                    sendResponse(res, response);
                });
            }
        }
    }).catch((error) => {
        console.log(error);

        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;

        sendResponse(res, response);
    });
};

const deleteOne = function (req, res) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: process.env.HTTP_STATUS_OKs,
        data: null,
    }

    Anime_findById(animeId).then(anime => {
        if (anime === null) {
            response.status = process.env.HTTP_STATUS_NOT_FOUND;
            response.data = {
                error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
            }

            sendResponse(res, response);
        } else {
            const character = anime.characters.id(characterId);

            if (character === null) {
                response.status = process.env.HTTP_STATUS_NOT_FOUND;
                response.data = {
                    error: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
                };

                sendResponse(res, response);
            } else {
                // TODO: FIX Later
                anime.characters.pull({_id: characterId})

                anime.save().then(
                    (newAnime) => {
                        response.status = process.env.HTTP_STATUS_OK;
                        response.data = anime;
                    }
                ).catch(error => {
                    response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
                    response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;
                }).finally(() => {
                    sendResponse(res, response);
                });
            }
        }
    }).catch((error) => {
        console.log(error);

        response.status = process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR;
        response.data = process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG;

        sendResponse(res, response);
    });
};

module.exports = {
    findOne,
    findAllWithPagination: findAll,
    addOne,
    updateOne,
    partiallyUpdateOne,
    deleteOne,
};
