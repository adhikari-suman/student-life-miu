
const findOne = function(req, res){
    res.status(200).send("Found one character");
}

const findAllWithPagination = function(req, res){
    res.status(200).send("Found paginated characters");
}

const addOne = function(req, res){
    res.status(200).send("Add one character");
}

const updateOne = function(req, res){
    res.status(200).send("Update one character");
}

const partiallyUpdateOne = function(req, res){
    res.status(200).send("Patch one character");
}

const deleteOne = function(req, res){
    res.status(200).send("Deleted one character");
}

module.exports = {
    findOne,
    findAllWithPagination,
    addOne,
    updateOne,
    partiallyUpdateOne,
    deleteOne
}