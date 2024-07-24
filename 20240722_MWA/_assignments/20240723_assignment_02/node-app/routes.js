const fs = require("fs");
const path = require("path");

const serveIndexFile = function (req, res) {
    fs.readFile(path.join(__dirname, 'public', 'index.html'), (err, data) => {
        if (err) {
            res.writeHead(500);
            res.end("Something went wrong");
        } else {
            res.setHeader('Content-Type', 'text/html');
            res.writeHead(200);
            res.end(data);
        }
    });
};

const servePage1 = function (req, res) {
    fs.readFile(path.join(__dirname, 'public', 'page1.html'), (err, data) => {
        if (err) {
            res.writeHead(500);
            res.end("Something went wrong");
        } else {
            res.setHeader('Content-Type', 'text/html');
            res.writeHead(200);
            res.end(data);
        }
    });
};

const servePage2 = function (req, res) {
    fs.readFile(path.join(__dirname, 'public', 'page2.html'), (err, data) => {
        if (err) {
            res.writeHead(500);
            res.end("Something went wrong");
        } else {
            res.setHeader('Content-Type', 'text/html');
            res.writeHead(200);
            res.end(data);
        }
    });
};

const serveJson = function (req, res) {
        res.setHeader('Content-Type', 'application/json');
        res.writeHead(200);
        res.end(JSON.stringify({message: 'Hello World!'}));
}

const serveAllRequests = function (req, res) {

    switch(req.method){
        case 'GET':
            switch (req.url) {
                case '/':
                case '/index.html':
                    serveIndexFile(req, res);
                    break;

                case '/page1.html':
                    servePage1(req, res);
                    break;
                case '/page2.html':
                    servePage2(req, res);
                    break;

                default:
                    res.writeHead(404);
                    res.end(`Route ${req.url} not found`);
                    break;
            }
            break;

        case 'POST':
            switch (req.url) {
                case '/json':
                    serveJson(req, res);
                    break;

                default:
                    res.writeHead(404);
                    res.end(`Route ${req.url} not found`);
                    break;
            }
            break;
    }


};



module.exports = serveAllRequests;