const characterController = require("./character.controller");
const router = require('express').Router();

router
    .route(process.env.API_ANIME_CHARACTER_SUBSET_ROUTE_CHARACTER)
    .get(characterController.findAll)
    .post(characterController.addOne);

router
    .route(process.env.API_ANIME_CHARACTER_SUBSET_ROUTE_CHARACTER_BY_ID)
    .get(characterController.findOne)
    .put(characterController.fullUpdateOne)
    .patch(characterController.partiallyUpdateOne)
    .delete(characterController.deleteOne);

module.exports = router;
