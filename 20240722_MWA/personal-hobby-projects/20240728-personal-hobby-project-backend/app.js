require('dotenv').config();
require('./database/mongodb');
const express = require('express');
const routes = require('./routes');

const app = express()


app.use(express.json());
app.use(express.urlencoded({extended: true}));
app.use(process.env.API_SUBSET_ROUTE_API_WITH_VERSION_V1, routes);

const serverListenCallback = function () {
    console.log(`${process.env.SERVER_MESSAGE_LISTENING_ON_PORT} ${server.address().port}`)
};

const server = app.listen(process.env.PORT, serverListenCallback);

