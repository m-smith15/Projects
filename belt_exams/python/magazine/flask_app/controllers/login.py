from flask import render_template, redirect, request, session, flash
from flask_app import app

from flask_app.models.login import User
from flask_app.models.magazine import Magazine

# --- CONTROLLER ---  

from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route("/")
def login_page():
    if session.get("is_logged_in") is not None:
        return redirect("/dashboard")
    return render_template("index.html")

@app.route("/dashboard")
def dashboard_page():
    if session.get("is_logged_in") is not None:
        magazines = Magazine.get_all_magazines() 
        return render_template("dashboard.html", get_magazines = magazines) #is logged in
    else:
        print("user is not logged in")
        return redirect('/')


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

    return redirect("/dashboard")

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

    return redirect("/dashboard")

@app.route("/logout")
def logout():

    session.pop('email', None)
    session.pop('is_logged_in', None)
    session.pop('first_name', None)
    session.pop('user_id', None)
    
    return redirect('/')

@app.route('/show/<int:magazineid>')
def view_one_magazine(magazineid):

    if session.get("is_logged_in") is not None:
        data = {
            "id": magazineid
        }
        magazine = Magazine.get_magazine_by_id(data)
        subscribers = Magazine.get_subscribers(data)
        return render_template("one_magazine.html", get_magazine = magazine, get_subscriptions = subscribers)

    return render_template("index.html")

@app.route('/magazine/new')
def add_new_magazine():
    if session.get("is_logged_in") is not None:
        return render_template("add_magazine.html")

    return render_template("index.html")

@app.route('/magazine/add', methods=["POST"])
def submit_new_magazine():

    # validate submission first 
    validate_magazine = Magazine.validate_submission()
    if not validate_magazine:
        flash("please correct errors and resubmit")
        return redirect("/magazine/new")

    data = {
        "title": request.form["title"],
        "description": request.form["description"],
        "users_id": session["user_id"]
    }

    # run query to add
    Magazine.add_a_magazine(data)

    return redirect('/dashboard')

@app.route('/user/account')
def view_account():
    if session.get("is_logged_in") is not None:

        user_data = {
            "email": session["email"]
        }
        user_info = User.get_account_info(user_data)
        users_magazines = Magazine.get_magazine_by_user(user_data)
        subscriber_count = Magazine.get_subscribers_count()

        return render_template("update_user.html", user_info = user_info, users_magazines = users_magazines, subscribers = subscriber_count)

    return render_template("index.html")

@app.route('/user/update', methods=["POST"])
def update_user():
    user_email = {
        "email": request.form["email"]
    }
    user_validations = User.validate_update(user_email)
    if not user_validations:
        flash("please correct errors and resubmit")
        return redirect("/user/account")
    user_data = {
        "old_email":session['email'],
        "email": request.form["email"],
        "first_name": request.form["first_name"],
        "last_name": request.form["last_name"]
    }
    User.update_user(user_data)

    new_user_info = User.get_account_info(user_email)
    #once in DB reset session cookies
    session.clear()
    #assign new values
    session['is_logged_in'] = True
    session['email'] = user_email["email"]
    session['first_name'] = request.form["first_name"]
    session['user_id'] = new_user_info.id

    return redirect('/user/account')

@app.route('/magazine/delete/<int:magazinenum>')
def delete_magazine(magazinenum):

    data = {
        "id": magazinenum
    }
    Magazine.delete_magazine(data)

    return redirect('/user/account')

@app.route('/subscribe/<int:magazineid>')
def subscribe_to_magazine(magazineid):
    subscribe_data = {
        "users_id": session['user_id'],
        "magazine_id": magazineid
    }

    Magazine.add_subscriber(subscribe_data)

    return redirect('/dashboard')