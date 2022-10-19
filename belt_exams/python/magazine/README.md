# Magazine belt exam
  - The prompt for this exam was to build a working application with Login/Registration page along with a fully CRUD model revolving magazines. There is also the ability for users to "subscribe" to magazines. The user, magazine, and subscriptions are stored in a mySQL workbench datatbase on the back end.

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [Usage](#usage)
* [Acknowledgements](#acknowledgements)


## General Information
- You can find the site on http://3.23.104.32/
  - You can login with my favorte test user - Shrimp Shrimpton. Username: shrimp@ocean.com pw: shrimp


## Technologies Used
 - Bcrypt
 - Creating and monitoring cookies in session storage
 - Validation checks:
    - User Logged In?
    - Email exists (Regex check via Re library)
 - Error messaging with Flash
 - Jinja templating to display information
 - Magazine, User, and subscription data are stored in a mySQL database!


## Features
 - Ability to create, read, update, destory magazines
  - Can also subscribe to them (only increases "Subscriber" count currently..)
 - Login and Registration extensive validation checks (on creation OR when updating user)
  - Email: exists, is email
  - password: hashed with Bcrypt, matches confirm password
  - First/Last name: 3 characters minimum

## Setup
 - Can find requirements in the Pipfile.lock

## Usage
 - Create a user and subscribe to a magazine! Add a magazine to the database

## Acknowledgements
- A big thank you to the folks who created [this template](https://github.com/ritaly/README-cheatsheet)
