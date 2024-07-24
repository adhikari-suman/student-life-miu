const fs = require("fs");
const path = require("path");


const router = require('express').Router()

router.route('/')
    .get( (req, res) => {
    fs.readFile(path.join(__dirname, 'public', 'index.html'), (err, data) => {
        if (err) {
            res.status(500).send("Something went wrong!");
        } else {
            res.setHeader('Content-Type', 'text/html');
            res.status(200).send(data);
        }
    });
});

module.exports = router;