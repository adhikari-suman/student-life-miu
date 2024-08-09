const jwt = require('jsonwebtoken');

const authenticate = function (req, res, next) {
    const authHeader = req.headers['authorization'];

    if (!authHeader) {
        res.status(401).json({error: 'No token provided'});
        return;
    }

    try {
        const token = authHeader.split(' ')[1];
        jwt.verify(token, process.env.JWT_SECRET_KEY);
        next();
    } catch (e) {
        res.status(401).json({
            error: 'Unauthorized',
        });
    }
}

module.exports = authenticate;
