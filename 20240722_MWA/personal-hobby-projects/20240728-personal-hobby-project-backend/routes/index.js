const router = require("express").Router();
const animeController = require("../api/anime/anime.controller");
const animeRouter = require("../api/anime/anime.router");
const userRouter = require("../api/user/user.router");

router.use(process.env.API_ANIME_ANIME_SUBSET_ROUTE_ANIME, animeRouter);
router.use(process.env.API_USER_SUBSET_ROUTE_USERS, userRouter);

module.exports = router;
