from flask_app.config.mysqlconnection import connectToMySQL 
from flask import flash, request, json
import re
#since this is MODEL need to reach out to DB

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

# import tables from oah_db (schema)
class User:
    def __init__(self, data):
        self.id = data["id"]
        self.first_name = data["first_name"]
        self.last_name = data["last_name"]
        self.email = data["email"]
        self.password = data["password"]

    @classmethod
    def create_user(cls, user_data):

        query = "INSERT INTO users (first_name, last_name, email, password) VALUES (%(first_name)s, %(last_name)s, %(email)s, %(password)s);"

        return connectToMySQL('oah_db').query_db(query, user_data)
    
    @classmethod
    def validate_login(cls, user_data):
        query = "SELECT * FROM users WHERE email = %(email)s"
        results = connectToMySQL('oah_db').query_db(query, user_data)
        if len(results) < 1:
            return False
        #need to move results list to a dict so a user class can be instantiated
        results_dict = {
            'id': results[0][0],
            'first_name': results[0][1],
            'last_name': results[0][2],
            'email':results[0][3],
            'password': results[0][4]
        }
        return cls(results_dict)

    @staticmethod
    def validate_registration():
        is_valid = True
        if len(request.form["first_name"]) < 3:
            flash("Name must be at least 2 characters long!")
            is_valid = False
        if len(request.form["last_name"]) < 3:
            flash("Last Name must be at least 2 characters long!")
            is_valid = False
        if not EMAIL_REGEX.match(request.form["email"]):
            flash("Must use a valid email!")
            is_valid = False
        if len(request.form["password"]) < 3:
            flash("pasword less than 3 - replace with bcrypt")
            is_valid = False
        return is_valid

    @staticmethod
    def existing_user_check(email_check):
        is_valid = True

        query = "SELECT * FROM users WHERE email = %(email)s;"

        results = connectToMySQL('oah_db').query_db(query, email_check)

        print(len(results))

        if len(results) != 0:
            flash("That email is already in use")
            is_valid = False

        if request.form["password"] != request.form["password_confirm"]:
            flash("Passwords must match!")
            is_valid = False

        return is_valid


