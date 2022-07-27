import requests
import os
from flask import render_template, redirect, session, jsonify, request
from flask_app import app

@app.route('/')
def search_page():

    return render_template("index.html")

@app.route('/search', methods=['POST'])
def searching():
    print(request.form['query'])
    # now we inject the query into our string
    r = requests.get(f"https://us.api.blizzard.com/data/wow/connected-realm/4728/auctions/2?namespace=dynamic-classic-us&locale=en_US&access_token={os.environ.get('Bearer')}")

    # r = requests.get(f"https:api.information.com/{os.environ.get('FLASK_API_KEY')}/search?={request.form['query']}")
    # we must keep in line with JSON format.
    # requests has a method to convert the data coming back into JSON.
    return jsonify(r.json())
