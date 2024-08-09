const mongoose = require("mongoose");
const bcrypt = require("bcryptjs");
const jwt = require("jsonwebtoken");
const sendResponse = require("../../utils/send_response");

const UserModel = mongoose.model(process.env.MONGODB_USER_MODEL_NAME);

const login = function (req, res) {
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

const register = function (req, res) {
    const newUser = {
        fullName: req.body.fullName,
        username: req.body.username,
        password: bcrypt.hashSync(req.body.password, parseInt(process.env.BCRYPT_SALT_ROUNDS)),
        email: req.body.email,
    };

    UserModel.create(newUser).then((_) => {
        res.status(201).json({
            success: true,
            data: 'User created successfully',
        });
    }).catch(error => {
        res.status(500).json(error);
    });
}

const findOne = function (req, res) {
    const username = req.params.username;

    const response = {
        status: 200,
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
