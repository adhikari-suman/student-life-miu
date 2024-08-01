require('dotenv').config();
require('./database/mongodb').openConnection();
const fs = require('fs');
const path = require('path');



const routes = require('./routes');
const express = require('express');
const json = express.json;
const urlencoded = express.urlencoded;

const app = express()

app.use('/', function (req, res, next) {
    res.header('Access-Control-Allow-Origin', 'http://localhost:4200');
    next();
});

app.use(json());
app.use(urlencoded( {extended: true}))
app.use('/', routes);

app.use(express.static('public'));

const application = app.listen(process.env.PORT, () => {
    console.log(`Listening on port ${application.address().port}`);
})
