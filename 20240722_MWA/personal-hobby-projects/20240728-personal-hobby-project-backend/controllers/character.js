const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const MongoDBConstants = require("../constants").MongoDBConstants;
const callbackify = require("util").callbackify;
const animeModel = mongoose.model(MongoDBConstants.MODEL_ANIME);

const character_findAllPaginated = function (animeId, page, size) {
  let offset = (page - 1) * size;
  return animeModel
    .findById(animeId)
    .slice("characters", [offset, size])
    .exec()
    .then((anime) => (anime ? anime.characters : []));
};

const character_findAllPaginatedCallback = callbackify(
  character_findAllPaginated
);

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

const findOne = function (req, res) {
  res.status(200).send("Found one character");
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
  
      character_findAllPaginatedCallback(animeId, page, size, character_onMongooseResponseCallback(req, res));
    } else {
      res.status(400).json({ error: "Anime Id is required." });
    }
  };

const addOne = function (req, res) {
  res.status(200).send("Add one character");
};

const updateOne = function (req, res) {
  res.status(200).send("Update one character");
};

const partiallyUpdateOne = function (req, res) {
  res.status(200).send("Patch one character");
};

const deleteOne = function (req, res) {
  res.status(200).send("Deleted one character");
};

module.exports = {
  findOne,
  findAllWithPagination,
  addOne,
  updateOne,
  partiallyUpdateOne,
  deleteOne,
};
