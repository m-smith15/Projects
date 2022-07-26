const mongoose = require("mongoose");

//setup the schema w/ mongoose, also set some basic validations
const GoalSchema = new mongoose.Schema({
    goalType: {
        type: String,
        required: [
            true,
            "Type is required"
        ]
    },
    goal: {
        type: String,
        required: [
            true,
            "Goal is required"
        ]
    },
    timeToCompletion: {
        type: String,
        required: [
            true,
            "Timeline is required"
        ]
    },
    challenges: {
        type: String,
        required: [
            true,
            "Challenges are required"
        ]
    }
}, { timestamps: true });

module.exports.Goal = mongoose.model('Goal', GoalSchema);
//dont forget to export