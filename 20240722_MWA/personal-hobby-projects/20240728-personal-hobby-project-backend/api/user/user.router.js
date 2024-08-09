const userController = require("./user.controller");
const router = require('express').Router();
const authenticate = require("./auth.middleware");

router
    .route('/authenticate')
    .post(userController.login);

router
    .route('')
    .post(userController.register);

router.route('/:username')
    .get(authenticate, userController.findOne);

module.exports = router;
