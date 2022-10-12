from flask_app.config.mysqlconnection import connectToMySQL 
from flask import flash, request

class Magazine:
    def __init__(self,data):
        self.id = data['id']
        self.title = data['title']
        self.description = data['description']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all_magazines(cls):
        query = "SELECT * FROM magazine JOIN users ON magazine.users_id = users.id;"
        return connectToMySQL('magazine_schema').query_db(query)
    
    @classmethod
    def get_magazine_by_id(cls, data):
        query = "SELECT * FROM magazine JOIN users ON magazine.users_id = users.id WHERE magazine.id = %(id)s"
        return connectToMySQL('magazine_schema').query_db(query, data)

    @classmethod
    def add_a_magazine(cls, data):
        query = "INSERT INTO magazine (title, description, users_id) VALUES (%(title)s, %(description)s, %(users_id)s);"

        return connectToMySQL('magazine_schema').query_db(query, data)

    @classmethod
    def get_magazine_by_user(cls, data):
        query = "SELECT * FROM users JOIN magazine ON users.id = magazine.users_id WHERE users.email = %(email)s;"

        return connectToMySQL('magazine_schema').query_db(query, data)

    @classmethod
    def delete_magazine(cls, data):
        query = "DELETE FROM magazine WHERE id = %(id)s"

        return connectToMySQL('magazine_schema').query_db(query,data)

    @classmethod
    def add_subscriber(cls, data):
        query = "INSERT INTO subscriptions (users_id, magazine_id) VALUES (%(users_id)s, %(magazine_id)s);"
        return connectToMySQL('magazine_schema').query_db(query, data)

    @classmethod
    def get_subscribers(cls, data):
        query = "SELECT * FROM subscriptions JOIN magazine ON magazine.id = subscriptions.magazine_id JOIN users ON subscriptions.users_id = users.id WHERE subscriptions.magazine_id = %(id)s"
        return connectToMySQL('magazine_schema').query_db(query, data)

    @classmethod
    def get_subscribers_count(cls):
        query = "SELECT subscriptions.magazine_id, COUNT(magazine.id) as count FROM magazine JOIN subscriptions on magazine.id = subscriptions.magazine_id GROUP BY magazine.id"

        return connectToMySQL('magazine_schema').query_db(query)


    @staticmethod
    def validate_submission():
        is_valid = True
        if len(request.form["title"]) < 2:
            flash("Title must be at least 2 characters long!")
            is_valid = False
        if len(request.form["description"]) < 10:
            flash("Description must be at least 10 characters long!")
            is_valid = False
        return is_valid