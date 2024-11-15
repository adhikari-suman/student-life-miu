const router = require('express').Router();
const multipicationController = require('./controllers/multiplication');

router.route("/multiply/:firstOperand")
.get(multipicationController.multiply);


module.exports = router;