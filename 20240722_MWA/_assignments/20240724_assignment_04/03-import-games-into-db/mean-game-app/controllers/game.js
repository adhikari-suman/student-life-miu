const mongodb = require('../database/mongodb');

const findAll = function (req, res) {
    let size = 3;
    let offset = 0;

    if (req.query && req.query.size){
        size = parseInt(req.query.size);

        size = Math.max(3, Math.min(size, 7));
    }

    if (req.query && req.query.page){
        page = parseInt(req.query.page);

        offset = (page - 1 ) * size;
    }

    console.log(offset, size);


    const db = mongodb.getConnection();

    const allGames = db.collection('games').find().skip(offset).limit(size).toArray(
        function(err, games){
            if(err != null){
                res.status(500).json({error:"Something went wrong"});
            } else {
                res.status(200).json(games);
            }
        }
    );
}

module.exports = {
    findAll,
}