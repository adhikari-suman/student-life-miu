require('dotenv').config();
const express = require('express');
const routes = require('./routes');

const server = express();

server.use('/api', routes);

const app = server.listen(process.env.PORT, ()=>{
    console.log("Serving on port",app.address().port);
});