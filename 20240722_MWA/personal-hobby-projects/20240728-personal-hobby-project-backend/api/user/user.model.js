const mongoose = require('mongoose');

const userSchema = mongoose.Schema({
    email: {
        type: String,
        required: true,
        unique: true,
    },
    username: {
        type: String,
        required: true,
        unique: true,
    },
    fullName: {
        type: String,
        required: true,
        minlength: parseInt(process.env.MONGODB_USER_MODEL_NAME_MIN),
        maxlength: parseInt(process.env.MONGODB_USER_MODEL_NAME_MAX),
    },
    password: {
        type: String,
        required: true,
    },
});

mongoose.model(process.env.MONGODB_USER_MODEL_NAME, userSchema, process.env.MONGODB_USER_COLLECTION_NAME);
