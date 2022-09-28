const { User } = require('../models/user.model');

module.exports.register = (request, response) => {
    User.create(request.body)
        .then(user => {
            response.json({ msg: "success!", user: user });
        })
        .catch(err => response.json(err));
}