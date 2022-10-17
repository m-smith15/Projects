const mongoose = require('mongoose');
const PirateSchema = new mongoose.Schema({
    pirateName: {
        type: String,
        required: [
            true,
            "pirateName is required"
        ]},
    image: {
        type: String,
        required: [
            true,
            "image is required"
        ]},
    treasure: {
        type: Number,
        required: [
            true,
            "treasure is required"
        ],
        min: [0, "Treasure must be 0 or greater"]},
    catchPhrase: {
        type: String,
        required: [
            true,
            "catchPhrase is required"
        ]},
    position: {
        type: String,
        required: [
            true,
            "position is required"
        ],
        minlength: [3, "Please select a position!"]
    },
    peg_leg: {
        type: Boolean,
        required: [
            true,
            "peg_leg is required"
        ]},
    eye_patch: {
        type: Boolean,
        required: [
            true,
            "eye_patch is required"
        ]},
    hook_hand: {
        type: Boolean,
        required: [
            true,
            "hook_hand is required"
        ]}
}, { timestamps: true } );
//setup the schema w/ mongoose, also set some basic validations
module.exports.Pirate = mongoose.model('Pirate', PirateSchema);
//dont forget to export
