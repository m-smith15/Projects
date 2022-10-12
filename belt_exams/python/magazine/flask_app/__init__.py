from flask import Flask

app = Flask(__name__)
app.secret_key = "j'aime mon pere"

from flask_app.controllers import login
