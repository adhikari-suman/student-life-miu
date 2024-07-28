const findOne = function(req, res){
    res.status(200).send("Found one anime");
}

const findAllWithPagination = function(req, res){
    res.status(200).send("Found paginated animes");
}

const addOne = function(req, res){
    res.status(200).send("Add one anime");
}

const updateOne = function(req, res){
    res.status(200).send("Update one anime");
}

const partiallyUpdateOne = function(req, res){
    res.status(200).send("Patch one anime");
}

const deleteOne = function(req, res){
    res.status(200).send("Deleted one anime");
}

module.exports = {
    findOne,
    findAllWithPagination,
    addOne,
    updateOne,
    partiallyUpdateOne,
    deleteOne
}