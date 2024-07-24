require('dotenv').config();
const fs = require('fs');
const path = require('path');
const http = require('http');
const serveAllRequests = require('./routes')

const server = http.createServer(serveAllRequests);


const application = server.listen(process.env.PORT, () => {
    console.log(`Listening on port ${application.address().port}`);
});