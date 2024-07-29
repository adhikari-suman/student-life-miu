const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const MongoDBConstants = require("../constants").MongoDBConstants;
const callbackify = require("util").callbackify;
const animeModel = mongoose.model(MongoDBConstants.MODEL_ANIME);

const character_findAllPaginated = function (animeId, page, size) {
  let offset = (page - 1) * size;
  return animeModel
    .findById(animeId)
    .slice('characters', [offset, size])
    .exec();
};

const character_findById = function (animeId, characterId) {
  return animeModel
  .findById(animeId).select('characters').exec();
};

const character_addOne = function (animeId, character) {
  return animeModel
    .findByIdAndUpdate(animeId, { $push: { characters: character } }, { new: true, runValidators: true })
    .exec();
};

const character_updateOne = function (animeId, characterId, character) {
  return animeModel
    .findOneAndUpdate({ _id: animeId, "characters._id": characterId }, { $set: { "characters.$": character } }, { new: true, runValidators: true })
    .exec();
};

const character_deleteOne = function (animeId, characterId) {
  return animeModel
    .findByIdAndUpdate(animeId, { $pull: { characters: { _id: characterId } } }, { new: true })
    .exec();
};

const character_findAllPaginatedCallback = callbackify(character_findAllPaginated);
const character_findByIdCallback = callbackify(character_findById);
const character_createCallback = callbackify(character_addOne);
const character_updateOneCallback = callbackify(character_updateOne);
const character_partiallyUpdateOneCallback = callbackify(character_updateOne);
const character_deleteOneCallback = callbackify(character_deleteOne);

const character_onMongooseResponseCallback = function (req, res) {
  return function (error, character) {
    if (error) {
      console.log(error);
      res.status(500).json({ error: "Something went wrong." });
    } else {
      if (character == null) {
        res.status(404).json({ error: "Character not found." });
      } else {
        res.status(200).json(character);
      }
    }
  };
};

const character_onMongooseFindAllResponseCallback = function (req, res) {
    return function (error, anime) {
      if (error) {
        console.log(error);
        res.status(500).json({ error: "Something went wrong." });
      } else {
        if (anime.characters == null) {
          res.status(404).json({ error: "Character not found." });
        } else {
          res.status(200).json(anime.characters);
        }
      }
    };
  };

  const character_onMongooseFindOneResponseCallback = function (req, res, characterId) {
    return function (error, anime) {
      if (error) {
        console.log(error);
        res.status(500).json({ error: "Something went wrong." });
      } else {
        let character = anime.characters.id(characterId);


        if (character == null) {
          res.status(404).json({ error: "Character not found." });
        } else {
          res.status(200).json(character);
        }
      }
    };
  };

const findOne = function (req, res) {
  if (req.params && req.params.id && req.params.characterId) {
    let animeId = req.params.id;
    let characterId = req.params.characterId;

    if (!ObjectId.isValid(animeId) || !ObjectId.isValid(characterId)) {
      res.status(400).json({ error: "Id is invalid." });
      return;
    }

    character_findByIdCallback(animeId, characterId, character_onMongooseFindOneResponseCallback(req, res, characterId));
  } else {
    res.status(400).json({ error: "Anime Id and Character Id are required." });
  }
};

const findAllWithPagination = function (req, res) {
  let page = parseInt(process.env.QUERY_PAGE_DEFAULT);
  let size = parseInt(process.env.QUERY_SIZE_DEFAULT);

  if (req.query && req.query.page) {
    page = parseInt(req.query.page);
  }

  if (req.query && req.query.size) {
    size = parseInt(req.query.size);
  }

  if (isNaN(page) || isNaN(size) || page < 1 || size < 1 || size > 20) {
    res.status(400).json({
      error: "Page and size must be greater than one and size cannot be greater than 20.",
    });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(400).json({ error: "Anime Id is invalid." });
      return;
    }

    character_findAllPaginatedCallback(animeId, page, size, character_onMongooseFindAllResponseCallback(req, res));
  } else {
    res.status(400).json({ error: "Anime Id is required." });
  }
};

const addOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({ error: "Body cannot be empty." });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(400).json({ error: "Anime Id is invalid." });
      return;
    }

    const character = {
      name: req.body.name,
      characteristics: req.body.characteristics,
    };

    character_createCallback(animeId, character, character_onMongooseResponseCallback(req, res));
  } else {
    res.status(400).json({ error: "Anime Id is required." });
  }
};

const updateOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({ error: "Body cannot be empty." });
    return;
  }

  if (req.params && req.params.id && req.params.characterId) {
    let animeId = req.params.id;
    let characterId = req.params.characterId;

    if (!ObjectId.isValid(animeId) || !ObjectId.isValid(characterId)) {
      res.status(400).json({ error: "Id is invalid." });
      return;
    }

    const character = {
      name: req.body.name,
      characteristics: req.body.characteristics,
    };

    character_updateOneCallback(animeId, characterId, character, character_onMongooseResponseCallback(req, res));
  } else {
    res.status(400).json({ error: "Anime Id and Character Id are required." });
  }
};

const partiallyUpdateOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({ error: "Body cannot be empty." });
    return;
  }

  if (req.params && req.params.id && req.params.characterId) {
    let animeId = req.params.id;
    let characterId = req.params.characterId;

    if (!ObjectId.isValid(animeId) || !ObjectId.isValid(characterId)) {
      res.status(400).json({ error: "Id is invalid." });
      return;
    }

    const character = {
      name: req.body.name,
      characteristics: req.body.characteristics,
    };

    character_partiallyUpdateOneCallback(animeId, characterId, character, character_onMongooseResponseCallback(req, res));
  } else {
    res.status(400).json({ error: "Anime Id and Character Id are required." });
  }
};

const deleteOne = function (req, res) {
  if (req.params && req.params.id && req.params.characterId) {
    let animeId = req.params.id;
    let characterId = req.params.characterId;

    if (!ObjectId.isValid(animeId) || !ObjectId.isValid(characterId)) {
      res.status(400).json({ error: "Id is invalid." });
      return;
    }

    character_deleteOneCallback(animeId, characterId, character_onMongooseResponseCallback(req, res));
  } else {
    res.status(400).json({ error: "Anime Id and Character Id are required." });
  }
};

module.exports = {
  findOne,
  findAllWithPagination,
  addOne,
  updateOne,
  partiallyUpdateOne,
  deleteOne,
};
