import requests
import os
from flask import render_template, redirect, session, jsonify, request, json
from flask_app import app
# from flask_paginate import Pagination, get_page_parameter
#rom rest_framework.views.paginations import LimitOffsetResultPaginator

@app.route('/search')
def search_page():
    if session.get("is_logged_in") is None:
        return redirect("/")
    # print("Client ID is " + os.environ.get('Client_ID'))
    # print("Client Secret is " + os.environ.get('Client_Secret'))


    def get_bearer():
        url = "https://us.battle.net/oauth/token"

        data = {
            "grant_type": 'client_credentials',
            "scope": 'api',
            "client_id": os.environ.get('Client_ID'),
            "client_secret": os.environ.get('Client_Secret')
        }

        response = requests.post(url, data=data)
        # print(response)
        jsonResponse = response.json()
        # print(jsonResponse)
        return jsonResponse['access_token']

    os.environ['Bearer'] = get_bearer()

    # print("Bearer is " + os.environ['Bearer'])

    #adding in an api call for realm list to build options
    realmListAPI = requests.get(f"https://us.api.blizzard.com/data/wow/realm/index?namespace=dynamic-classic-us&locale=en_US&access_token={os.environ.get('Bearer')}")
    print("API realm call complete")

    realmListJSON = realmListAPI.json()

    #print(realmListJSON)

    realmList = []

    for realm in realmListJSON['realms']:
        if realm['name'].startswith('US1') or realm['name'].startswith('US2'): {
        }
        else: {
        realmList.append([realm['name'], realm['id']])
        }

    sortedRealmList = sorted(realmList, key=lambda d: d[0])
    
    print(sortedRealmList)
    #print(realmList[1][1])

    return render_template("index.html", realmList = sortedRealmList)

@app.route('/results', methods=['POST'])
def searching():
    # print(request.form['query']) #returns as str by default
    itemSearched = request.form['query']
    serverChosen = request.form['selectRealm']
    # 2 = alliance 6 = horde 7 = bbah
    factionChosen = request.form['selectFaction']

    #Leaving this in for now. Will be tricky based on how the search API works for WoW. Seems like you get *Like results of what you search from blizz api
    searchItem = requests.get(f"https://us.api.blizzard.com/data/wow/search/item?namespace=static-us&name.en_US={itemSearched}&orderby=id&_page=1&access_token={os.environ.get('Bearer')}")
    print("Search API complete")
    print(os.environ.get('Bearer'))

    dict = requests.get(f"https://us.api.blizzard.com/data/wow/connected-realm/{serverChosen}/auctions/{factionChosen}?namespace=dynamic-classic-us&locale=en_US&access_token={os.environ.get('Bearer')}").json()
    print("Auction API call complete")
    results = []
    resultsQuantity = 0
    resultsTotal = 0
    #looping through all auctions in API for ID of item searched
    for auction in dict['auctions']:
        if auction['item']['id'] == int(itemSearched):
            resultsQuantity += 1
            auction['buyout'] = round(auction['buyout']/10000,2)
            resultsTotal += auction['buyout']
            results.append(auction)

    #rounding total results
    if resultsTotal > 0:
        resultsAverage = round(resultsTotal / resultsQuantity, 2)
        print(resultsAverage)
        print(int(resultsTotal))
    else:
        resultsAverage = "n/a "


    sortedResults = sorted(results, key=lambda d: d['buyout'])
    page = request.args.get('page')
    print(sortedResults)

    print(page)


# ----------- pagination building  -------------

    # if page and page.isdigit():
    #     page = int(page)
    # else:
    #     page = 1
    # #sortedResults = sortedResults.paginate(page=page, per_page=10)
    # PER_PAGE = 3
    # pagination = Pagination(page=page, per_page=PER_PAGE, total=int(resultsTotal), search= True, record_name='query results')
    # i=(page-1)*PER_PAGE
    # sortedResults1=sortedResults[i:i+5]
    # print(sortedResults1)
    # print(pagination.items)

    print("------testing--------")
    # testing = LimitOffsetResultPaginator(sortedResults).paginate(limit=3, offset=0, count=int(resultsTotal))
    # print(testing)


    #resultsJson = json.dumps(results)
    #print(sortedResults)
    # we must keep in line with JSON format.
    # requests has a method to convert the data coming back into JSON.
    return render_template("results.html", results = sortedResults, quantity = resultsQuantity, itemSearched = itemSearched, average = resultsAverage)

# @app.route('/results')
# def search_results():

#     return render_template("results.html")

# @app.route('/retrieve_data')
# def retrieve():
#     PER_PAGE=5
#     connection = MongoClient()
#     db=connection.rheoML
#     fs = gridfs.GridFS(db)
#     search = False
#     q = request.args.get('q')
#     if q:
#         search = True
#     try:
#         page = int(request.args.get('page', 2))
#     except ValueError:
#         page = 1
#     List=fs.list()
#     pagination = Pagination(page=page,per_page=PER_PAGE, total=len(List), search=search, record_name='List')
#     #return   render_template("retrieveFile.html",List=List,fs=fs,form="submitIt",pagination=pagination,)

#     try:
#     page = int(request.args.get('page', 1))
# except ValueError:
#     page = 1

# List=fs.list()
# i=(page-1)*PER_PAGE
# List1=List[i:i+5]
# pagination = Pagination(page=page,per_page=PER_PAGE, total=len(List), search=search, record_name='List')
# return render_template("retrieveFile.html",List=List1,fs=fs,form="submitIt",pagination=pagination,)