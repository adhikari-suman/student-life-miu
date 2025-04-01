const sendResponse = function(res, response){
    res.status(response.statusCode).json(response.data);
}

module.exports = {
    sendResponse
}