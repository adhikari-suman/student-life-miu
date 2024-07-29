const fs = require("fs");
const path = require("path");
const homeController = require('./controllers/home');
const gameController = require('./controllers/game');


const router = require('express').Router()

router.route('/')
    .get(homeController.serveIndexFile);

router.route('/games')
    .get(gameController.findAll)
    .post(gameController.addOne);

router.route('/games/:id')
    .put(gameController.updateOne)
    .patch(gamesController.partialUpdate)
    .get(gameController.findOne)
    .delete(gameController.deleteOne);

module.exports = router;