const userController = require("./user.controller");
const router = require('express').Router();
const authenticate = require("./auth.middleware");

router
    .route(process.env.API_SUBSET_ROUTE_AUTHENTICATION_ROUTE)
    .post(userController.login);

router
    .route(process.env.API_SUBSET_ROUTE_EMPTY)
    .post(userController.register);

router.route(process.env.API_SUBSET_ROUTE_FIND_BY_USERNAME_ROUTE)
    .get(authenticate, userController.findOne);

module.exports = router;
