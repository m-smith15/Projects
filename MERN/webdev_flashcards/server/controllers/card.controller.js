const { Card } = require("../models/card.model");

module.exports.index = (request, response) => {
    response.json({
        message: "C'est vrai! C'est l'indice!"
    });
}
module.exports.createCard = (request, response) => {
const { cardTitle, cardDescription } = request.body;
    Card.create({
        cardTitle,
        cardDescription
    })
        .then(card => response.json(card))
        .catch(err => response.json(err));
}
module.exports.getAllCards = (request, response) => {
    Card.find({})
        .then(card => response.json(card))
        .catch(err => response.json(err))
}
module.exports.getCard = (request, response) => {
    Card.findOne({_id:request.params.id})
        .then(card => response.json(card))
        .catch(err => response.json(err))
}