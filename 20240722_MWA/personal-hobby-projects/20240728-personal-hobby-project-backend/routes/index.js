const router = require("express").Router();
const animeController = require("../controllers/anime");
const characterController = require("../controllers/character");

// dummy route for testing
router
  .route("/animes")
  .get(animeController.findAllWithPagination)
  .post(animeController.addOne);

router
  .route("/animes/:id")
  .get(animeController.findOne)
  .put(animeController.updateOne)
  .patch(animeController.partiallyUpdateOne)
  .delete(animeController.deleteOne);

router
  .route("/animes/:id/characters")
  .get(characterController.findAllWithPagination)
  .post(characterController.addOne);

router
  .route("/animes/:id/characters/:characterId")
  .get(characterController.findOne)
  .put(characterController.updateOne)
  .patch(characterController.partiallyUpdateOne)
  .delete(characterController.deleteOne);

module.exports = router;
