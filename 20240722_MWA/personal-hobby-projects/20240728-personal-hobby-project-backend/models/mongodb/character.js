const mongoose = require("mongoose");

const characterSchema = mongoose.Schema({
  name: {
    type: String,
    required: true,
    min: 3,
    max: 50,
  },
  characteristics: [String],
});

module.exports = characterSchema;
