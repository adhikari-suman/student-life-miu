const students = require('../resources/data/school.json');


const findAll = function (req, res){
    res.status(200).json(students);
}

const findOne = function (req, res){

    const position = parseInt(req.params.position);

    if(position <=0 ){
        res.status(400).send("Position cannot be below 1.");
    } else if( position <= students.length  ){
        res.status(200).json(students[position - 1]);
    } else {
        res.status(404).end();
    }

    
}

module.exports = {
    findAll,
    findOne
}