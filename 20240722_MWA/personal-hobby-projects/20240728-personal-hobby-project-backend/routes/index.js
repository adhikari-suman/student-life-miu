const router = require("express").Router();
const animeController = require("../api/anime/anime.controller");
const animeRouter = require("../api/anime/anime.router");
const userRouter = require("../api/user/user.router");

router.use('/anime', animeRouter);
router.use('/users', userRouter);

module.exports = router;
