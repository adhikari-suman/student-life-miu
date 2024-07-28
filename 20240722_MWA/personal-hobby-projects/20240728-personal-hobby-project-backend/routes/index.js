const router = require('express').Router()

// dummy route for testing
router.route('/animes')
    .get(function(req, res){
        res.status(200).json([]);
    });

module.exports = router;