const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const sendResponse = require("../../utils/send_response");
const {response} = require("express");

const UserModel = mongoose.model(process.env.MONGODB_USER_MODEL_NAME);

const login_without_chained_promise = function (req, res) {
    const credentials = {
        username: req.body.username,
        password: req.body.password,
    }

    UserModel.findOne({username: credentials.username}).exec().then(databaseUser => {
        if (databaseUser === null) {
            res.status(401).send({
                error: "Unauthorized",
            })
        } else {
            const payload = {
                username: credentials.username,
            }

            if (bcrypt.compareSync(credentials.password, databaseUser.password)) {
                const token = jwt.sign(payload, process.env.JWT_SECRET_KEY);

                res.status(200).send({
                    accessToken: token,
                });
            } else {
                res.status(401).send({
                    error: "Unauthorized",
                })
            }
        }
    }).catch(error => {

        console.log(error);
        res.status(500).send({
            message: "Internal Server Error",
            error: error,
        })
    });
}

const getUnauthorizedErrorMessage = () => {
    const error = {
        status: parseInt(process.env.HTTP_STATUS_UNAUTHORIZED),
        message: process.env.ERROR_RESPONSE_UNAUTHORIZED
    }

    return error;
};

const getInternalErrorMessage = () => {
    const error = {
        status: 500,
        message: process.env.ERROR_RESPONSE_SOMETHING_WENT_WRONG,
    }

    return error;
};

const _doesUserExist = function (databaseUser) {
    return new Promise((resolve, reject) => {
        if (!databaseUser) {
            reject(getUnauthorizedErrorMessage());
        } else {
            resolve(databaseUser);
        }
    });
}

// const _setResponseToUnauthorized = function (response) {
//     return new Promise((resolve, reject) => {
//         console.log("_setResponseToUnauthorized: rejecting...");
//
//         response.status = 401;
//         response.data = "Unauthorized";
//
//         reject();
//     });
// }

const _doesPasswordMatch = function (passwordMatch) {
    return new Promise((resolve, reject) => {
        if (!passwordMatch) {
            reject(getUnauthorizedErrorMessage());
        } else {
            resolve();
        }
    });
}


const _setResponseToError = function (response, error) {
    response.status = error.status;
    response.data = error.message;
}

const _setResponseToLoginSuccess = function (response, token) {
    response.status = parseInt(process.env.HTTP_STATUS_OK);
    response.data = {
        token: token
    };
}

function _setResponseToDatabaseError(response, error) {
    response.status = parseInt(process.env.HTTP_STATUS_INTERNAL_SERVER_ERROR);
    response.data = error;
}

function _setResponseToUserCreated(response, createdUser) {
    response.status = parseInt(process.env.HTTP_STATUS_CREATED);
    response.data = createdUser;
}

function _generatePayload(username) {
    return new Promise((resolve, reject) => {
        resolve({
            username: username,
        });
    });
}


const login = function (req, res) {

    const loginDetails = {
        username: req.body.username,
        password: req.body.password,
    }

    const response = {
        status: 200,
        data: null,
    }

    UserModel.findOne({username: loginDetails.username}).exec()
        .then(databaseUser => _doesUserExist(databaseUser))
        // .catch(() => _setResponseToUnauthorized(response))
        .then(databaseUser => bcrypt.compare(loginDetails.password, databaseUser.password))
        .then(passwordMatch => _doesPasswordMatch(passwordMatch))
        // .catch(() => _setResponseToUnauthorized(response))
        .then(() => _generatePayload(loginDetails.username))
        .then((payload) => jwt.sign(payload, process.env.JWT_SECRET_KEY))
        .then((token) => _setResponseToLoginSuccess(response, token))
        .catch(error => _setResponseToError(response, error))
        .finally(() => {
            sendResponse(res, response);
        });
}


const register = function (req, res) {
    const newUser = {
        fullName: req.body.fullName,
        username: req.body.username,
        password: bcrypt.hashSync(req.body.password, parseInt(process.env.BCRYPT_SALT_ROUNDS)),
        email: req.body.email,
    };
    const response = {
        status: parseInt(process.env.HTTP_STATUS_CREATED),
        data: null,
    }

    UserModel.create(newUser)
        .then(createdUser => _setResponseToUserCreated(response, createdUser))
        .catch(error => _setResponseToDatabaseError(response, error))
        .finally(() => sendResponse(res, response));
}

const findOne = function (req, res) {
    const username = req.params.username;

    const response = {
        status: parseInt(process.env.HTTP_STATUS_OK),
        data: null,
    }

    UserModel.findOne({username: username}).exec().then(databaseUser => {
        if (databaseUser === null) {
            response.data = 'User not found';
            response.status = 404;
        } else {
            response.status = 200;
            response.data = {
                username: databaseUser.username,
                fullName: databaseUser.fullName,
                email: databaseUser.email,
            }
        }
    }).catch(e => {
        response.status = 500;
        response.data = {
            error: e
        };

    })
        .finally(() => {
            sendResponse(res, response);
        });
}

module.exports = {
    login,
    register,
    findOne
}
