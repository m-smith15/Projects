const { User } = require('../models/user.model');



module.exports.index = (request, response) => {
    response.json({
        message: "You've pinged USER the index!"
    });
}
module.exports.register = (request, response) => {
    User.create(request.body)
        .then(user => {
            response.json({ msg: "success!", user: user });
        })
        .catch(err => response.json(err));
}