const animeController = require("./anime.controller");
const characterRouter = require("./character.router");
const router = require('express').Router();

router
    .route("")
    .get(animeController.findAllWithPagination)
    .post(animeController.addOne);

router.use('', characterRouter);

router
    .route("/:id")
    .get(animeController.findOne)
    .put(animeController.fullUpdateOne)
    .patch(animeController.partiallyUpdateOne)
    .delete(animeController.deleteOne);

module.exports = router;
