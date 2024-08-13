const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const callbackify = require("util").callbackify;
const sendResponse = require('../../utils/send_response');
const AnimeModel = mongoose.model(process.env.MONGODB_ANIME_MODEL_NAME);
const characterDocumentName =
    process.env.MONGODB_ANIME_CHARACTERS_DOCUMENT_NAME;

const Anime_findById = function (animeId) {
    return AnimeModel.findById(animeId).exec();
}

const character_onMongooseFindOneResponseCallback = function (
    req,
    res,
    characterId
) {
    return function (error, anime) {
        if (error) {
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

const _setResponseToAnimeCharacters = (response, characters) => {
    response.status = parseInt(process.env.HTTP_STATUS_OK);
    response.data = characters;
};

const _setResponseToError = (response, error) => {
    console.log(error);
    response.status = error.status;
    response.data = error.data;
};

const _doesCharacterExist = (anime, characterId) => {
    return new Promise((resolve, reject) => {

        const character = anime.characters.id(characterId);

        if (!character) {
            const error = {
                status: parseInt(process.env.HTTP_STATUS_NOT_FOUND),
                data: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
            }

            reject(error);
        } else {
            resolve(anime);
        }
    });
};


const findAll = function (req, res) {
    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    const animeId = req.params.id;

    AnimeModel.findById(animeId).exec()
        .then((anime) => _doesAnimeExist(anime))
        .then(anime => _setResponseToAnimeCharacters(response, anime.characters))
        .catch((error) => _setResponseToError(response, error))
        .finally(() => sendResponse(res, response));
};

const _setResponseToAnimeCharacter = (response, characters, characterId) => {
    const character = characters.id(characterId);

    if (character === null) {
        response.status = parseInt(process.env.HTTP_STATUS_NOT_FOUND);
        response.data = {
            error: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
        };
    } else {
        response.status = parseInt(process.env.HTTP_STATUS_OK);
        response.data = character;
    }
};

const findOne = function (req, res) {
    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    const animeId = req.params.id;
    const characterId = req.params.characterId;

    AnimeModel.findById(animeId).exec()
        .then((anime) => _doesAnimeExist(anime))
        .then(anime => _setResponseToAnimeCharacter(response, anime.characters, characterId))
        .catch((error) => _setResponseToError(response, error))
        .finally(() => sendResponse(res, response));
};

const _addNewCharacter = (anime, newCharacter) => {
    return new Promise((resolve, reject) => {
        anime.characters.push(newCharacter);

        resolve(anime);
    });
};

const addOne = function (req, res) {
    const response = {
        status: parseInt(process.env.HTTP_STATUS_CREATED),
        data: process.env.SUCCESS_RESPONSE_CHARACTER_ADDED,
    }

    const animeId = req.params.id;

    const newCharacter = {
        name: req.body.name,
        characteristics: req.body.characteristics,
    }


    AnimeModel.findById(animeId).exec()
        .then((anime) => _doesAnimeExist(anime))
        .then(anime => _addNewCharacter(anime, newCharacter))
        .then(anime => anime.save())
        .catch((error) => _setResponseToError(response, error))
        .finally(() => sendResponse(res, response));
};

const _doesAnimeCharacterExist = (anime, characterId) => {
    return new Promise((resolve, reject) => {
        const character = anime.characters.id(characterId);

        if (character === null) {
            const error = {
                status: parseInt(process.env.HTTP_STATUS_NOT_FOUND),
                data: process.env.ERROR_RESPONSE_CHARACTER_NOT_FOUND,
            }

            reject(error);
        } else {
            console.log('_doesAnimeCharacterExist resolved');
            resolve(anime);
        }

    });


};

const _updateAnimeCharacterFull = (anime, characterId, update) => {
    return new Promise((resolve, reject) => {
        const character = anime.characters.id(characterId);

        character.characteristics = update.characteristics;
        character.name = update.name;

        resolve(anime);
    });
};

const _updateAnimeCharacterPartial = (anime, characterId, update) => {
    return new Promise((resolve, reject) => {
        const character = anime.characters.id(characterId);

        if (update.characteristics) {
            character.characteristics = update.characteristics;
        }

        if (update.name) {
            character.name = update.name;
        }

        resolve(anime);
    });
};

const updateOne = function (req, res, updateFunction) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: process.env.SUCCESS_RESPONSE_CHARACTER_UPDATE,
    }

    const update = {
        name: req.body.name,
        characteristics: req.body.characteristics,
    }

    AnimeModel.findById(animeId).exec()
        .then((anime) => _doesAnimeExist(anime))
        .then((anime) => _doesAnimeCharacterExist(anime, characterId))
        .then(anime => updateFunction(anime, characterId, update))
        .then(anime => anime.save())
        .catch((error) => _setResponseToError(response, error))
        .finally(() => {
            sendResponse(res, response);
        });
};

const fullUpdateOne = function (req, res) {
    updateOne(req, res, _updateAnimeCharacterFull);
}

const partiallyUpdateOne = function (req, res) {
    updateOne(req, res, _updateAnimeCharacterPartial);
};

const _removeCharacterFromAnime = (anime, characterId) => {
    return new Promise((resolve, reject) => {

        console.log('_removeCharacterFromAnime reached');
        const character = anime.characters.id(characterId);

        if (character) {
            console.log(character);
            character.remove();
        }

        console.log('_removeCharacterFromAnime resolved');
        resolve(anime);
    });
};

const _setResponseToInternalServerError = (response, error) => {
    response.status = parseInt(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR);
    response.data = error;
};
const deleteOne = function (req, res) {
    const animeId = req.params.id;
    const characterId = req.params.characterId;

    const response = {
        status: parseInt(process.env.HTTP_STATUS_NO_CONTENT), // Default status
        data: null,
    };


    const filter = {
        $pull: {
            characters: {_id: characterId},
        }
    };

    const options = {new: true};


    AnimeModel.findByIdAndUpdate(animeId, filter, options).exec()
        .then((anime) => _doesAnimeExist(anime))
        .catch((error) => _setResponseToInternalServerError(response, error))
        .finally(() => {
            sendResponse(res, response);
        });
};

module.exports = {
    findOne,
    findAll,
    addOne,
    fullUpdateOne,
    partiallyUpdateOne,
    deleteOne,
};
