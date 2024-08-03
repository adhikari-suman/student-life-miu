const router = require("express").Router();
const animeController = require("../controllers/anime");
const animeRouter = require("./anime");

// dummy route for testing
router.use('/anime', animeRouter);

module.exports = router;
