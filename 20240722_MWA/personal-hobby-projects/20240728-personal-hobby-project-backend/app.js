require('dotenv').config();
require('./database/mongodb');
const express = require('express');
const routes = require('./routes');

const app = express()

const _corsMiddleware = function (req, res, next) {
    res.header(process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN_KEY, process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN_VALUE);
    res.header(process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_HEADERS_KEY, process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_HEADERS_VALUE);
    res.header(process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_METHODS_KEY, process.env.CORS_HEADER_ACCESS_CONTROL_ALLOW_METHODS_VALUE);

    next();
};

app.use(_corsMiddleware);

app.use(express.json());
app.use(express.urlencoded({extended: true}));
app.use(process.env.API_SUBSET_ROUTE_API_WITH_VERSION_V1, routes);

const serverListenCallback = function () {
    console.log(`${process.env.SERVER_MESSAGE_LISTENING_ON_PORT} ${server.address().port}`)
};

const server = app.listen(process.env.PORT, serverListenCallback);

