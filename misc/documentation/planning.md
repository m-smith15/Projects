The requirements for this project are as follows:
    - SPA
    - Consume API (api.mathjs.org) 
        - Display simple addition of 2 vairables 'A' and 'B'
        - End users will have a prompt to input what they believe the end result would be
            -Display if the solution is correct or not
            **This application is designed for 2nd graders, incorrect solutions should not be met with discouraging messaging/imagry
    - Application should be self explanitory

Non-coding requirements:
    - Building out a README.md (see /README.md for readme guideance)
    - Include section of future features to add

Misc:
    - Do not upload to public github repo
    - Photo of user interaction with interface and how services communicate (Balsamiq?)

Building:
    - Create repo, react app, and upload to PRIVATE repo on GitHub
    - Install dependencies (express, axios, cors, bootstrap?)
    - Get familiar with mathjs API 
        - https://api.mathjs.org/#get
        - Takes in parameters, so we'll generate random integers from 0-30 for variables "A" and "B" on page load/reload.
            - Postman to the rescue; looks like we can use the following format:  http://api.mathjs.org/v4/?expr=[VAR_A]%2B[VAR_B]
            - This returns the result of adding the 2 parameters together. We'll check that against user input and display appropriate messaging
                - Since we're just doing addition of integers, we don't need to worry about decimal places (yet...)
    - Wireframe
        - See wireframe.png for initial mock-up of design!

Enhancements:
    - Increasing range of numbers to be added (currently integers 1-30)
    - Add in decimals
        - Would need to adjust API call to specify the number of decimal places to look
    - Create a "scratch-paper" section where end users can click to add tic-marks for visual learners
        - I envision this as a text-box area where end users could click a button to add tic-marks (up to 60) or subtract tic-marks
    - add in ability for subtraction, muliplication, division
        - Two ways to approach this, section out the current page or scale up with different routes based on the algebra
    - gamification: leaderboard? high score for session?
        - Many moblie apps implement this. Could do a running tally for current score for classrooms to compete for top score on multiple devices
    - Front-End: add in images, visual events for successful/incorrect answers to make it more exciting
        - I've opted for a simple but friendly approach for now. I assume that most 2nd graders consume their electronic media via Smartphone or Tablet so I kept that in mind. Didn't want anything being covered up by the touch-keyboard that appears, and didn't want to complicate the application with too much verbiage 
    - Research: talk to instructors to see where many 1st-3rd graders are struggling in math, and what successful methods they've used
    - Added and leaving in MVC framework for scalability. It doesn't make sense for a backend to be added yet, but leaving the option should that change in the future.