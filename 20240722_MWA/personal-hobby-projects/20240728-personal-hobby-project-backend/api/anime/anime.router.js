const animeController = require("./anime.controller");
const characterController = require("./character.controller");
const router = require('express').Router();

router
    .route("")
    .get(animeController.findAllWithPagination)
    .post(animeController.addOne);

router
    .route("/:id")
    .get(animeController.findOne)
    .put(animeController.fullUpdateOne)
    .patch(animeController.partiallyUpdateOne)
    .delete(animeController.deleteOne);

router
    .route("/:id/characters")
    .get(characterController.findAllWithPagination)
    .post(characterController.addOne);

router
    .route("/:id/characters/:characterId")
    .get(characterController.findOne)
    .put(characterController.updateOne)
    .patch(characterController.partiallyUpdateOne)
    .delete(characterController.deleteOne);

module.exports = router;
