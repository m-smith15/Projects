const CardController = require('../controllers/card.controller');
//building out routes to be used

module.exports = function(app){
    app.get('/api', CardController.index);
    app.post('/api/card', CardController.createCard);
    app.get('/api/card', CardController.getAllCards);
    app.get('/api/card/:id', CardController.getCard);
    // app.put('/api/card/:id', CardController.updateCard);
    // app.delete('/api/card/:id', CardController.deleteCard);
}