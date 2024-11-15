const multiply = function (req, res){
    const firstOperand = parseInt(req.params.firstOperand);
    const secondOperand = parseInt(req.query.secondOperand);

    const result = firstOperand * secondOperand;

    res.status(200).end(result.toString());
}

module.exports = {
    multiply
}