const mongoDBClient = require('mongodb').MongoClient;

let _connection = null;

const _mongoDBConnectionHandler = function(err, client){
    if(err){
        console.log("Failed to conenct to database.");
    } else {
        _connection = client.db('meanGames');

        console.log("Connected to db.");
    }
};

const openConnection = function(){
    if(getConnection() !== null){
        return;
    }



    mongoDBClient.connect(process.env.MONGO_CONNECTION_URL, _mongoDBConnectionHandler);
}

const getConnection = function(){
    return _connection;
}


module.exports={
    openConnection,
    getConnection
}