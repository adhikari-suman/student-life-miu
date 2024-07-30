const mongoose = require("mongoose");
const publisherSchema = require("./publisher");
const reviewSchema = require("./review");
const gameSchema = mongoose.Schema({
  title: {
    type: String,
    required: true,
  },
  year: Number,
  rate: {
    type: Number,
    min: 1,
    max: 5,
    default: 1,
  },
  price: Number,
  minPlayers: {
    type: Number,
    min: 1,
    max: 10,
  },
  maxPlayers: {
    type: Number,
    min: 1,
    max: 10,
  },
  minAge: Number,
  designers: [String],
  // publisher: publisherSchema,
  // reviews: [reviewSchema],
});

mongoose.model(process.env.MONGODB_GAME_MODEL_NAME, gameSchema, process.env.MONGODB_GAME_COLLECTION_NAME);
