const mongoose = require('mongoose');
mongoose.connect("mongodb://localhost/pirate_life", {
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
    .then(() => console.log("Connected with the DB!"))
    .catch(err => console.log("Got an error connecting to DB", err));
//creating if not present, and logging connection to mongodb 