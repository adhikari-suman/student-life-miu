const mongodb = require('../database/mongodb');
const ObjectId = require('mongodb').ObjectId;

const deleteOne = function (req, res) {
    const gameId = req.params.id;

    const db = mongodb.getConnection();

    const filter = {_id:  ObjectId(gameId)};

    const deleteOneGameCallBack = function(error, message){
        if(error != null){
            res.status(500).json({error:"Something went wrong"});
        } else {
            res.status(200).json(message);
        }
    }

    const findOneGameCallBack = function(err, game){
        if(err != null){
            res.status(500).json({error:"Something went wrong"});
        } else {
            if(game === null){
                res.status(404).end();
            } else {
                db.collection('games').deleteOne(filter, deleteOneGameCallBack);
            }
        }
    };

    db.collection('games').findOne(filter, findOneGameCallBack);
}


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

    const db = mongodb.getConnection();

    db.collection('games').find().skip(offset).limit(size).toArray(
        function(err, games){
            if(err != null){
                res.status(500).json({error:"Something went wrong"});
            } else {
                res.status(200).json(games);
            }
        }
    );
}

const _validateGameJson = function(game,  callback){

    let error = null;
    let success = null;

    if (!game.title){
        error = "Title must be provided."
    } else if(!game.price){
        error =  "Price must be provided.";
    } else if(!game.minPlayers){
        error = "Minimum players must be provided.";
    } else if(game.minPlayers<1 || game.minPlayers>10 ){
        error = "Minimum players must be between 1 and 10.";
    } else if(!game.minAge){
        error = "Minimum age must be provided.";
    } else if(game.minAge <7 || game.minAge >99){
        error = "Minimum age must be between 7 and 99.";
    } 

    if(error === null){
        success = game;
    }

    callback(error, success);
}

const addOne = function(req, res){
    const newGame = req.body;

    _validateGameJson(newGame, function(error, game){
        if(error){
            res.status(400).json({
                error: error
            });
        } else {
            const db = mongodb.getConnection(); 

        db.collection('games').insertOne(newGame, function(err, response){
            if(err != null){
                res.status(500).json({error:"Something went wrong"});
            } else {
                res.status(200).json(response);
            }
        });
        }
    });
}

const updateOne = function(req, res){
    const game = req.body;
    const gameId = req.params.id;

    const filter = {_id: ObjectId(gameId)};
    const update = {$set: {...game}};

    console.log(update);

    _validateGameJson(game, function(error, game){
        if(error){
            res.status(400).json({
                error: error
            });
        } else {
            const db = mongodb.getConnection(); 

        db.collection('games').updateOne(filter, update, function(err, successMessage){
            if(err != null){
                console.log(error);
                res.status(500).json({error:"Something went wrong"});
            } else {
                res.status(200).json(successMessage);
            }
        });
        }
    });
}

const findOne = function (req, res) {
    const gameId = req.params.id;

    const db = mongodb.getConnection();

    const filter = {_id:  ObjectId(gameId)};

    const findOneGameCallback = function(err, game){
        if(err != null){
            res.status(500).json({error:"Something went wrong"});
        } else {
            res.status(200).json(game);
        }
    };

    db.collection('games').findOne(filter, findOneGameCallback);
}


module.exports = {
    findAll,
    findOne,
    addOne,
    updateOne,
    deleteOne
}