require('dotenv').config();
const express = require('express');

const app = express()

const server = app.listen(process.env.PORT, function(){
    console.log(`Listening on port: ${server.address().port}`)
});

