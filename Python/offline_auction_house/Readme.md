# Offline Auction House
  - This is a site where you can query for the most recent prices of items in Classic WoW!


## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Big takeaways](#Big-takeaways)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Acknowledgements](#acknowledgements)


## General Information
- One aspect of games I enjoy is the economy! Traditionally, I've always created and maintained a number of spreadsheets which were manually updated to monitor and track prices of materials or rare items. The idea being when prices of materials hit a threshhold, I could turn them into other items for a profit!
  -  This project was an attempt to bring that all into a website. While maintaining the spreadsheets "worked" - manually updating them was tedious, and required my character to sit at an Auction House whle I updated.
  -  This project was aimed to allow me to query the most recent prices of items anywhere in the game, or not even logged in at all!

## Technologies Used
  - Flask Framework
  - API calls from Blizzard's API's
  - Login and Registration Page
    - Bcrypt pw hashing
    - Flash messaging on field validation
    - Regex check for email validation


## Big takeaways
- Working with APIs
- Lamda Function!
- Managing large JSON returns!


## Setup
Dependencies are located in the pipfile.lock!


## Usage
Select the Classic WoW Server, Faction, and enter the item ID you'd like to query!

Click send and away you go!
(There are some helpful IDs on the landing page!)


## Project Status
Project is: _in progress_! 
  - I plan to continue to work on this and further iron out details in my free time.


## Room for Improvement
  - I enjoy steelblue as much as the next person, but too much is too much
  - The Blizzard Auction House API I'm using sends back data for ALL auctions. 
    - I'd like to use this to only have to query once every 10-15 minutes, then hold onto that data to make others quicker.
  - Hook this up to MySQL Workbench and pass ALL the data that returns from the queries there:
    - Create a 7 day historical graph of the prices
  - Futher integrate the wowhead tooltip scripting

## Acknowledgements
- Many thanks to [the creator's of this template](https://github.com/ritaly/README-cheatsheet/blob/master/README.md)!
