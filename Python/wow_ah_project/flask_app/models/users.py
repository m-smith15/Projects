from flask_app.config.mysqlconnection import connectToMySQL 
#since this is MODEL need to reach out to DB

# import tables from users schema
class Users:
    def __init__(self,data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM users;"
        results = connectToMySQL('users_schema').query_db(query)
        users = []
        # Iterate over the db results and create instances of users with cls.
        for user in results:
            users.append( cls(user) )
        return users

    @classmethod
    def save(cls, data ):
        query = "INSERT INTO users ( first_name , last_name , email , created_at, updated_at ) VALUES ( %(first_name)s , %(last_name)s , %(email)s , NOW() , NOW() );"
        # data was created in users controller > we're using the values gathered there to insert into database
        return connectToMySQL('users_schema').query_db( query, data )

    @classmethod
    def delete(cls, data):
        query = "DELETE FROM users WHERE (id = %(id)s);"
        return connectToMySQL('users_schema').query_db( query, data )

    @classmethod
    def show_one(csl, data):
        query = "Select * FROM users where (id=%(id)s);"
        return connectToMySQL('users_schema').query_db( query, data )

    @classmethod
    def edit(csl, data):
        query = "UPDATE users SET first_name=%(first_name)s, last_name=%(last_name)s, email=%(email)s WHERE id=%(id)s;"
        return connectToMySQL('users_schema').query_db( query, data )

