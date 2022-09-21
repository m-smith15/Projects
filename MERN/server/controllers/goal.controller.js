const { Goal } = require('../models/goal.model');

module.exports.index = (request, response) => {
    response.json({
        message: "You've pinged the index!"
    });
}
module.exports.createGoal = (request, response) => {
    const { goalType, goal, timeToCompletion, challenges } = request.body;
    Goal.create({
        goalType,
        goal,
        timeToCompletion,
        challenges
    })
        .then(goal => response.json(goal))
        .catch(err => response.status(400).json(err));
}
module.exports.getAllGoals = (request, response) => {
    Goal.find({})
        .then(goal => response.json(goal))
        .catch(err => response.json(err));
}
module.exports.updateGoal = (request, response) => {
    Goal.findOneAndUpdate({_id:request.params.id}, request.body, {new:true})
        .then(updatedGoal => response.json(updatedGoal))
        .catch(err => response.json(err))
}
module.exports.deleteGoal = (request, response) => {
    Goal.deleteOne({_id: request.params.id })
        .then(deleteConfirmation => response.json(deleteConfirmation))
        .catch(err => response.json(err))
}