const PirateController = require('../controllers/pirate.controller');
//building out routes to be used

module.exports = function(app){
    app.get('/api', PirateController.index);
    app.post('/api/pirate', PirateController.createPirate);
    app.get('/api/pirate', PirateController.getAllPirates);
    app.get('/api/pirate/:id', PirateController.getPirate);
    app.put('/api/pirate/:id', PirateController.updatePirate);
    app.delete('/api/pirate/:id', PirateController.deletePirate);
}