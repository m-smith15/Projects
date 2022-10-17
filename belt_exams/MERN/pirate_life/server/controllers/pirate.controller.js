const { Pirate } = require("../models/pirate.model");

module.exports.index = (request, response) => {
    response.json({
        message: "You've pinged the index!"
    });
}
module.exports.createPirate = (request, response) => {
    const { pirateName, image, treasure, catchPhrase, position, peg_leg, eye_patch, hook_hand } = request.body;
    Pirate.create({
        pirateName,
        image,
        treasure,
        catchPhrase,
        position,
        peg_leg,
        eye_patch,
        hook_hand
    })
        .then(pirate => response.json(pirate))
        .catch(err => response.status(400).json(err));
}
module.exports.getAllPirates = (request, response) => {
    Pirate.find({})
        .then(pirate => response.json(pirate))
        .catch(err => response.json(err))
}
module.exports.getPirate = (request, response) => {
    Pirate.findOne({_id:request.params.id})
        .then(pirate => response.json(pirate))
        .catch(err => response.json(err))
}
module.exports.updatePirate = (request, response) => {
    Pirate.findOneAndUpdate({_id:request.params.id}, request.body, {new:true})
        .then(updatedPirate => response.json(updatedPirate))
        .catch(err => response.json(err))
}
module.exports.deletePirate = (request, response) => {
    Pirate.deleteOne({_id: request.params.id })
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}