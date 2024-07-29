require('dotenv').config();
require('./database/mongodb');
const express = require('express');
const routes = require('./routes');

const app = express()
app.use('/api/v1', routes);

const server = app.listen(process.env.PORT, function(){
    console.log(`Listening on port: ${server.address().port}`)
});

