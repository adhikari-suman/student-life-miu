const mongoose = require("mongoose");

const characterSchema = mongoose.Schema({
    name: {
        type: String,
        required: true,
        min: parseInt(process.env.MONGODB_ANIME_MODEL_CHARACTER_SUB_DOCUMENT_NAME_MIN),
        max: parseInt(process.env.MONGODB_ANIME_MODEL_CHARACTER_SUB_DOCUMENT_NAME_MAX),
    },
    characteristics: [String],
});

module.exports = characterSchema;
