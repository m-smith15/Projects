from flask import render_template, redirect, session
from flask_app import app


@app.route('/')
def search_page():

    return render_template("index.html")