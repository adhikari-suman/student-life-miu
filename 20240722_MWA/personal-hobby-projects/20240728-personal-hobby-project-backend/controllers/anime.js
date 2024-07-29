const { error } = require("console");
const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const MongoDBConstants = require("../constants").MongoDBConstants;
const callbackify = require("util").callbackify;
const animeModel = mongoose.model(MongoDBConstants.MODEL_ANIME);

const anime_findAllPaginated = function (page, size) {
  let offset = (page - 1) * size;

  return animeModel.find().skip(offset).limit(size).exec();
};

const anime_findById = function (animeId) {
  return animeModel.findById(animeId);
};

const anime_addOne = function (anime) {
  return animeModel.create(anime);
};

const anime_updateOne = function(animeId, anime){
  const filter = {_id: new ObjectId(animeId)};
  const change = {$set: anime};

  return animeModel.updateOne(filter, change);
}

const anime_findAllPaginatedCallback = callbackify(anime_findAllPaginated);
const anime_findByIdCallback = callbackify(anime_findById);
const anime_createCallback = callbackify(anime_addOne);
const anime_updateOneByCallback = callbackify(anime_updateOne);
const anime_partiallyUpdateOneByCallback = callbackify(anime_updateOne);

const anime_onMongooseResponseCallback = function (req, res) {
  return function (error, anime) {
    if (error) {
      console.log(error);

      res.status(500).json({
        error: "Something went wrong.",
      });
    } else {
      if (anime == null) {
        res.status(404).json({
          error: "Anime not found.",
        });
      } else {
        res.status(200).json(anime);
      }
    }
  };
};

const findOne = function (req, res) {
  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(400).json({
        error: "Id is invalid.",
      });
      return;
    }

    anime_findByIdCallback(animeId, anime_onMongooseResponseCallback(req, res));
  } else {
    res.status(400).json({
      error: "Id is required.",
    });
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
      error:
        "Page and size must be greater than one and size cannot be greater than 20.",
    });
    return;
  }

  anime_findAllPaginatedCallback(
    page,
    size,
    anime_onMongooseResponseCallback(req, res)
  );
};

const addOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({
      error: "Body cannot be empty.",
    });
    return;
  }

  const anime = {
    name: req.body.name,
    releaseDate: req.body.releaseDate,
    studio: req.body.studio,
    characters: req.body.characters,
  };

  anime_createCallback(anime, anime_onMongooseResponseCallback(req, res));
};

const updateOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({
      error: "Body cannot be empty.",
    });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(400).json({
        error: "Id is invalid.",
      });
      return;
    }

    const anime = {
      name: req.body.name,
      releaseDate: req.body.releaseDate,
      studio: req.body.studio,
      characters: req.body.characters,
    };

    anime_updateOneByCallback(animeId, anime, anime_onMongooseResponseCallback(req, res));
    
  } else {
    res.status(400).json({
      error: "Id is required.",
    });
  }
};

const partiallyUpdateOne = function (req, res) {
  if (!req.body) {
    res.status(400).json({
      error: "Body cannot be empty.",
    });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(400).json({
        error: "Id is invalid.",
      });
      return;
    }

    const anime = {
      name: req.body.name,
      releaseDate: req.body.releaseDate,
      studio: req.body.studio,
      characters: req.body.characters,
    };

    anime_partiallyUpdateOneByCallback(animeId, anime, anime_onMongooseResponseCallback(req, res));
    
  } else {
    res.status(400).json({
      error: "Id is required.",
    });
  }
};

const deleteOne = function (req, res) {
  res.status(200).send("Deleted one anime");
};

module.exports = {
  findOne,
  findAllWithPagination,
  addOne,
  updateOne,
  partiallyUpdateOne,
  deleteOne,
};
