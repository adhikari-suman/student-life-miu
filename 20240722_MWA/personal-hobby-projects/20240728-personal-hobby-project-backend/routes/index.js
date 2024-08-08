const router = require("express").Router();
const animeController = require("../api/anime/anime.controller");
const animeRouter = require("../api/anime/anime.router");

// dummy route for testing
router.use('/anime', animeRouter);

module.exports = router;
