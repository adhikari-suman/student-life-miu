const mongoose = require("mongoose");
const characterSchema = require("./character.model");
const MongoDBConstants = require("../../constants").MongoDBConstants;

const animeSchema = mongoose.Schema({
    name: {
        type: String,
        min: 3,
        max: 50,
        required: true,
    },
    releaseDate: {
        type: Date,
        required: true,
    },
    studio: {
        type: String,
        min: 2,
        max: 50,
        required: true,
    },
    characters: [characterSchema],
});

mongoose.model(
    MongoDBConstants.MODEL_ANIME,
    animeSchema,
    MongoDBConstants.COLLECTION_ANIME
);
