from flask_app.config.mysqlconnection import connectToMySQL 
from flask import render_template, redirect, request, session, flash
from flask_app import app

from flask_app.models.users import User

# --- CONTROLLER ---  

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route("/")
def login_page():
    if session.get("is_logged_in") is not None:
        return redirect("/search")
    return render_template("login.html")


@app.route("/register", methods=["POST"])
def register():
    
    #look to see if they already exist in the DB or not
    email_check = {
        "email": request.form["email"]
    }

    if not User.existing_user_check(email_check):
        print("user exists")
        flash("Please correct errors and try again")
        return redirect('/')
    else:
        print("user does not exist in DB")

    #validation of the request form
    if not User.validate_registration():
        print("form entries are NOT valid")
        return redirect('/')
    else:
        print("form entries are valid")

    #pw hashing and dropping into DB
    pw_hash = bcrypt.generate_password_hash(request.form['password'])
    print(pw_hash)
    user_data = {
        "first_name": request.form["first_name"],
        "last_name": request.form["last_name"],
        "email": request.form["email"],
        "password": pw_hash
    }
    User.create_user(user_data)

    newid = User.validate_login(user_data)
    #once in DB add to session cookie
    session['is_logged_in'] = True
    session['email'] = user_data["email"]
    session['first_name'] = newid.first_name
    session['user_id'] = newid.id

    return redirect("/search")

@app.route("/login", methods=["POST"])
def login():
    
    user_data = {
        "email": request.form["email"]
    }
    user_exists = User.validate_login(user_data)

    if not user_exists:
        flash("invalid email")
        return redirect("/")

    if not bcrypt.check_password_hash(user_exists.password, request.form["password"]):
        flash("invalid Password")
        return redirect('/')

    session['is_logged_in'] = True
    session['email'] = user_data["email"]
    session['first_name'] = user_exists.first_name
    session['user_id'] = user_exists.id

    return redirect("/search")

@app.route("/login/demo")
def demo_login():
    
    session['is_logged_in'] = True
    session['email'] = 'demo@email.com'
    session['first_name'] = 'demo_user'
    session['user_id'] = '123'

    return redirect("/search")


@app.route("/logout")
def logout():

    session.pop('email', None)
    session.pop('is_logged_in', None)
    session.pop('first_name', None)
    session.pop('user_id', None)
        
    return redirect('/')
