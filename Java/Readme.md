# Divinity Original Sin 2 - Character Template
  - Project was undertaken to prevent some of the "napkin theorycrafting" my friends and I were doing between sessions. This lets us "build" potential characters, and save them to try when we have our next session!
    - This project was built in two parts - first being building a web scraper (check out the web scraper [repo](https://github.com/m-smith15/Projects/tree/master/Java/WebScraper2)), and the second was using the scraped data to build the site! 
  - Check the site out live via AWS: http://18.221.143.236
    - 503 means I most likely took it down. Playing with AWS so I can leave this up full time while remaining in the "free tier" of usage!

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Project Status](#project-status)
* [Room for Improvement](#room-for-improvement)
* [Acknowledgements](#acknowledgements)


## General Information
- My friends and I enjoy playing the Role Playing game Divinity Original Sin 2 together. However, our schedules do not frequently line up so that we have blocks of time where we are all free to sit down and play together.
- I created this project after countless times of losing potential character builds to lost "napkin theorycrafting"


## Technologies Used
 - Spring Boot
 - htmlunit library
 - CommandLineRunner interface


## Features
 - Built Webscraper from scratch!
 - Scraped data is passed into a MySQL Workbench Database
 - That data is then used to display spell information on webpage

## Setup
 - Project dependencies can be found in the pom.xml file

## Usage
 - Dream up a character idea that sounds fun to play!
 - Create that on the site, and allocate points to spell schools. The spells you're able to learn at those level breakpoints will be displayed!
 - Save the character to reference later!

## Project Status
Project is: _in progress_!
 - While the current version does accomplish what I wanted it to at a very basic level, there is MUCH to improve upon.


## Room for Improvement

Room for improvement:
- Improve the Webscraper so that the data coming through is cleaner.
  - This was/is a challenge because the information is coming from a wiki. Those are maintained and updated by any number of folks, so the table structures aren't uniform. It makes grabbing data difficult. 

To do:
- Make the display of potential spells friendlier
- Add in a section for Abilities
- Add in a section for Gear that can add to Spell School level
- Add a "required level" so you know what the minimum level is to put this together


## Acknowledgements
- A huge thank you to the folks at [Divinity Original Sin 2 Wiki](https://divinityoriginalsin2.wiki.fextralife.com/Divinity+Original+Sin+2+Wiki) for creating and maintaining the site!
- A big thank you to the folks who created [this template](https://github.com/ritaly/README-cheatsheet)
