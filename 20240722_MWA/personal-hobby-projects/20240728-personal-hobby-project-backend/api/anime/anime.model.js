const mongoose = require("mongoose");
const characterSchema = require("./character.model");

const animeSchema = mongoose.Schema({
    name: {
        type: String,
        min: parseInt(process.env.MONGODB_ANIME_MODEL_NAME_MIN),
        max: parseInt(process.env.MONGODB_ANIME_MODEL_NAME_MAX),
        required: true,
    },
    releaseDate: {
        type: Date,
        required: true,
    },
    studio: {
        type: String,
        min: parseInt(process.env.MONGODB_ANIME_MODEL_STUDIO_MIN),
        max: parseInt(process.env.MONGODB_ANIME_MODEL_STUDIOS_MAX),
        required: true,
    },
    characters: [characterSchema],
});

mongoose.model(
    process.env.MONGODB_ANIME_MODEL_NAME,
    animeSchema,
    process.env.MONGODB_ANIME_COLLECTION_NAME
);
