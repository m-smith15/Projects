//backend - fairly light for now. Wanted to have a structure in place for scalability in the future
const axios = require("axios")
const app = axios();
const port = 8000;

//leaving in some of the groundwork for addition of a database/backend

//successful start messaging
app.listen(port, () => {
    console.log(`server spinning up on port: ${port}`)
});