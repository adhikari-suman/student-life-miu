const jwt = require('jsonwebtoken');
const sendResponse = require('../../utils/send_response');

const authenticate = function (req, res, next) {
    const authHeader = req.headers[process.env.HEADER_AUTHORIZATION];

    if (!authHeader) {
        const response = {
            status: parseInt(process.env.HTTP_STATUS_UNAUTHORIZED),
            data: process.env.ERROR_RESPONSE_TOKEN_NOT_FOUND
        }

        sendResponse(res, response);
        return;
    }

    try {
        const token = authHeader.split(' ')[1];
        jwt.verify(token, process.env.JWT_SECRET_KEY);
        next();
    } catch (e) {
        const response = {
            status: parseInt(process.env.HTTP_STATUS_UNAUTHORIZED),
            data: process.env.ERROR_RESPONSE_UNAUTHORIZED
        }

        sendResponse(res, response);
    }
}

module.exports = authenticate;
