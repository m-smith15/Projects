require('dotenv').config();
const express = require('express');
const cors = require('cors')
const app = express();
const port = 8000;
//requiring the techs - express, cors, 
require('./server/config/mongoose.config');

const jwt = require("jsonwebtoken");

app.use(cors())
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
require('./server/routes/goal.route')(app);

app.listen(port, () => {
    console.log(`Spinning on port: ${port}`)
});
//success message