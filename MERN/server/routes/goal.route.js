const GoalController = require('../controllers/goal.controller');

module.exports = function(app){
    app.get('/api', GoalController.index);
    app.post('/api/goal', GoalController.createGoal);
    app.get('/api/goal', GoalController.getAllGoals);
    // app.get('/api/goal/:id', GoalController.getGoal);
    app.put('/api/goal/:id', GoalController.updateGoal);
    app.delete('/api/goal/:id', GoalController.deleteGoal);
}