- What does the application do? What is its purpose?
    - This application allows end users to practice their addition skills on a single page application (SPA).

- Development requirement to help other developers understand how to contribute to your code base (installing dependencies, spinning up a development server, running tests, etc.);
    - List of dependencies can be found in the client package.json folder
    - Once you've pulled down this repo use npm install in terminal to install dependencies
    - cd into the 'client' folder and use the terminal command 'npm run' to start this on localhost:3000 in browser

- How to build and deploy your application for production.
    - npm run build & push to GitHub
    - Create AWS EC2 instance (Ubuntu 20.04)
        - Create PEM file
        - SSH into the instance
    - Clone repo from GitHub and install dependencies 
    - install and configure nginx to display the web app! (no backend to setup just yet!)
