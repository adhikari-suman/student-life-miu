require('dotenv').config();
const fs = require('fs');
const path = require('path');
const routes = require('./routes');
const express = require('express');

const app = express()

app.use('/', routes);

app.use(express.static('public'));

const application = app.listen(process.env.PORT, () => {
    console.log(`Listening on port ${application.address().port}`);
})