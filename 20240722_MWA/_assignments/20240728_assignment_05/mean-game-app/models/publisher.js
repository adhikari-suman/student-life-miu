const mongoose = require('mongoose');

const publisherSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  country: String,
  established: Number, //Not a date since we only have year
  location: {
    address: String,
    // Store oordinates in order longitude (E/W), latitude (N/S) 
    coordinates: {
        type: [Number],
        index: "2dsphere"
    }
  },
});

module.exports = publisherSchema;
