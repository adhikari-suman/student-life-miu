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

const anime_findById = function(animeId){
    return animeModel.findById(animeId);
}



const anime_findAllPaginatedCallback = callbackify(anime_findAllPaginated);
const anime_findByIdCallback = callbackify(anime_findById);

const anime_onMongooseResponseCallback = function (req, res) {
  return function (error, anime) {
    if (error) {
      console.log(error);

      res.status(500).json({
        error: "Something went wrong.",
      });
    } else {

      if(anime == null){
        res.status(404).json({
          error: 'Anime not found.'
        });
      } else {
        res.status(200).json(anime);
      }
    }
  };
};

const findOne = function (req, res) {
    if(req.params && req.params.id){
        let animeId = req.params.id;

        if(!ObjectId.isValid(animeId)){
            res.status(400).json({
                error: "Id is invalid."
            })
            return; 
        }

        anime_findByIdCallback(animeId, anime_onMongooseResponseCallback(req, res));
    } else {
        res.status(400).json({
            error: "Id is required."
        })
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
  res.status(200).send("Add one anime");
};

const updateOne = function (req, res) {
  res.status(200).send("Update one anime");
};

const partiallyUpdateOne = function (req, res) {
  res.status(200).send("Patch one anime");
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
