
const games = require('../resources/data/games.json');

const findAll = (req, res)=>{
    res.status(200).json(games);
}

module.exports = {
    findAll,
}