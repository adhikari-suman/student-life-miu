module.exports = function sendResponse(res, response) {
    res.status(response.status).send(response.data);
}
