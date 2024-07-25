const fs = require("fs");
const path = require("path");
const homeController = require('./controllers/home');
const gameController = require('./controllers/game');


const router = require('express').Router()

router.route('/')
    .get(homeController.serveIndexFile);

router.route('/games')
    .get(gameController.findAll);

module.exports = router;