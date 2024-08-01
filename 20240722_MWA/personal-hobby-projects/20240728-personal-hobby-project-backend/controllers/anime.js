const mongoose = require("mongoose");
const ObjectId = mongoose.Types.ObjectId;
const callbackify = require("util").callbackify;
const animeModel = mongoose.model(process.env.MONGODB_ANIME_MODEL_NAME);

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

const anime_updateOne = function (animeId, anime) {
  const filter = { _id: new ObjectId(animeId) };
  const change = { $set: anime };

  return animeModel.updateOne(filter, change);
};

const anime_deleteOne = function (animeId) {
  const filter = { _id: new ObjectId(animeId) };

  return animeModel.deleteOne(filter);
};

const anime_findAllPaginatedCallback = callbackify(anime_findAllPaginated);
const anime_findByIdCallback = callbackify(anime_findById);
const anime_createCallback = callbackify(anime_addOne);
const anime_updateOneCallback = callbackify(anime_updateOne);
const anime_partiallyUpdateOneCallback = callbackify(anime_updateOne);
const anime_deleteOneCallback = callbackify(anime_deleteOne);

const anime_onMongooseResponseCallback = function (req, res) {
  return function (error, anime) {
    if (error) {
      res.status(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR).json({
        error: process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG,
      });
    } else {
      if (anime == null) {
        res.status(process.env.HTTP_STATUS_NOT_FOUND).json({
          error: process.env.ERROR_RESPONSE_ANIME_NOT_FOUND,
        });
      } else {
        res.status(process.env.HTTP_STATUS_OK).json(anime);
      }
    }
  };
};

const findOne = function (req, res) {
  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
        error: process.env.ERROR_RESPONSE_INVALID_OBJECT_ID,
      });
      return;
    }

    anime_findByIdCallback(animeId, anime_onMongooseResponseCallback(req, res));
  } else {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_ID_REQUIRED,
    });
  }
};

const findAllWithPagination = function (req, res) {
  let page = parseInt(process.env.QUERY_PAGE_DEFAULT);
  let size = parseInt(process.env.QUERY_SIZE_DEFAULT);
  const maxSize = parseInt(process.env.QUERY_MAX_SIZE_DEFAULT);

  if (req.query && req.query.page) {
    page = parseInt(req.query.page);
  }

  if (req.query && req.query.size) {
    size = parseInt(req.query.size);
  }

  if (isNaN(page) || isNaN(size) || page < 1 || size < 1 || size > maxSize) {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error:
      getPageAndMaxSizeErrorMessage(maxSize),
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
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_EMPTY_REQUEST_BODY,
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
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_EMPTY_REQUEST_BODY,
    });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
        error: process.env.ERROR_RESPONSE_INVALID_OBJECT_ID,
      });
      return;
    }

    const anime = {
      name: req.body.name,
      releaseDate: req.body.releaseDate,
      studio: req.body.studio,
      characters: req.body.characters,
    };

    anime_updateOneCallback(
      animeId,
      anime,
      anime_onMongooseResponseCallback(req, res)
    );
  } else {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_ID_REQUIRED,
    });
  }
};

const partiallyUpdateOne = function (req, res) {
  if (!req.body) {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_EMPTY_REQUEST_BODY,
    });
    return;
  }

  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
        error: process.env.ERROR_RESPONSE_INVALID_OBJECT_ID,
      });
      return;
    }

    const anime = {
      name: req.body.name,
      releaseDate: req.body.releaseDate,
      studio: req.body.studio,
      characters: req.body.characters,
    };

    anime_partiallyUpdateOneCallback(
      animeId,
      anime,
      anime_onMongooseResponseCallback(req, res)
    );
  } else {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_ID_REQUIRED,
    });
  }
};

const deleteOne = function (req, res) {
  if (req.params && req.params.id) {
    let animeId = req.params.id;

    if (!ObjectId.isValid(animeId)) {
      res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
        error: process.env.ERROR_RESPONSE_INVALID_OBJECT_ID,
      });
      return;
    }

    anime_deleteOneCallback(animeId, anime_onMongooseResponseCallback(req, res));
  } else {
    res.status(process.env.HTTP_STATUS_BAD_REQUEST).json({
      error: process.env.ERROR_RESPONSE_ID_REQUIRED,
    });
  }
};

const getPageAndMaxSizeErrorMessage= function(maxSize){
  return `${process.env.ERROR_RESPONSE_INVALID_PAGE_AND_SIZE_PARAMS} ${maxSize}.`
}

module.exports = {
  findOne,
  findAllWithPagination,
  addOne,
  updateOne,
  partiallyUpdateOne,
  deleteOne,
};
