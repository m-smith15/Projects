# Yoga belt exam
  - The prompt for this exam was to create a Yoga application for instructors. Users (instructors) will need to login or register, then they can Create/Read/Update/Delete yoga courses.
  - An added challenge for this was to create a "Students" field and have that interact with the mySQL DB on the backend in a M:M relationship, as well as deploying this to a public domain

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Acknowledgements](#acknowledgements)


## General Information
- You can find the site on http://18.223.23.14/
  - Feel free to use my main tester - Shrimp Shrimpton; user: shrimp@ocean.com pw: shrimp
- I hope you like steelblue!


## Technologies Used
 - Login and Registration
  - Field Validations
  - PW secruity with Bcrypt
 - Authorization - users can only edit yoga classes they created
 - Many to Many relationships within a mySQL db
 - mySQL
 - Spring Boot


## Features
 - Ability to create, read, update, destory yoga classes
 - Site is deployed on an Ubuntu server via AWS EC2 instance
 - 1:M and M:M relationships in mySQL schema
 - mySQL backend

## Setup
 - Requriements to run this on your machine can be found in the pom.xml

## Usage
 - Login as my default user, or create one of your own
 - Create and update a yoga class
 - Add students to thatt yoga class

## Acknowledgements
- A big thank you to the folks who created [this template](https://github.com/ritaly/README-cheatsheet)
