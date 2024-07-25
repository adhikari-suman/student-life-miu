const router = require('express').Router();
const studentController = require('./controllers/student');

router.route("/students")
.get(studentController.findAll);

router.route("/students/:position")
.get(studentController.findOne);


module.exports = router;