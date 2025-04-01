const { log } = require("console");
const mongoose = require("mongoose");
const callbackify = require("util").callbackify;
const Game = mongoose.model(process.env.MONGODB_GAME_MODEL_NAME);
const sendResponse = require("../util/response").sendResponse;
const { response } = require("express");

const Game_findPaginated = function (page, size) {
  let offset = (page - 1) * size;

  return Game.find().skip(page).limit(size).exec();
};

const Game_findWithCallback = callbackify(Game_findPaginated);

const deleteOne = function (req, res) {
  const gameId = req.params.id;
};

const findAll = function (req, res) {
  let response = {
    statusCode: 200,
    data: [],
  };

  let page = parseInt(process.env.QUERY_PAGE_DEFAULT);
  let size = parseInt(process.env.QUERY_SIZE_DEFAULT);

  if (req && req.query.page) {
    page = parseInt(req.query.page);
  }

  if (req && req.query.size) {
    size = parseInt(req.query.size);
  }

  if (
    isNaN(page) ||
    isNaN(size) ||
    page < 0 ||
    size < 0 ||
    size > process.env.QUERY_MAX_SIZE_DEFAULT
  ) {
    response.statusCode = 400;
    response.data = {
      error:
        "Page and Size must be positive numbers and size cannot be greater than " +
        process.env.QUERY_MAX_SIZE_DEFAULT,
    };
  }

  if (response.statusCode != 200) {
    sendResponse(res, response);
  } else {
    Game_findWithCallback(page, size, function (error, games) {
      if (error) {
        response = {
          statusCode: 500,
          data: { error: process.env.INTERNAL_SERVER_ERROR_MESSAGE },
        };
      } else {
        response = {
          statusCode: 200,
          data: games,
        };
      }

      sendResponse(res, response);
    });
  }
};

const addOne = function (req, res) {};

const fullUpdate = function (req, res) {};

const partialUpdate = function (req, res) {};

const findOne = function (req, res) {};

module.exports = {
  findAll,
  findOne,
  addOne,
  fullUpdate,
  partialUpdate,
  deleteOne,
};
