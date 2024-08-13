const characterController = require("./character.controller");
const router = require('express').Router();

router
    .route("/:id/characters")
    .get(characterController.findAll)
    .post(characterController.addOne);

router
    .route("/:id/characters/:characterId")
    .get(characterController.findOne)
    .put(characterController.updateOne)
    .patch(characterController.partiallyUpdateOne)
    .delete(characterController.deleteOne);

module.exports = router;
