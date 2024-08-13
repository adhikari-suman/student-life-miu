const animeController = require("./anime.controller");
const characterRouter = require("./character.router");
const router = require('express').Router();

router
    .route(process.env.API_SUBSET_ROUTE_EMPTY)
    .get(animeController.findAllWithPagination)
    .post(animeController.addOne);

router.use(process.env.API_SUBSET_ROUTE_EMPTY, characterRouter);

router
    .route(process.env.API_SUBSET_ROUTE_PARAM_ID)
    .get(animeController.findOne)
    .put(animeController.fullUpdateOne)
    .patch(animeController.partiallyUpdateOne)
    .delete(animeController.deleteOne);

module.exports = router;
