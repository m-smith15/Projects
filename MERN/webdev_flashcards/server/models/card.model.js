const mongoose = require('mongoose');
const CardSchema = new mongoose.Schema({
    cardTitle: {type: String},
    cardDescription: {type: String}
}, { timestamps: true } );
//setup the schema w/ mongoose, also set some basic validations
module.exports.Card = mongoose.model('Card', CardSchema);
//dont forget to export