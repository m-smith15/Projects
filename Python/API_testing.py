# from dotenv import load_dotenv

# from blizzardapi import BlizzardApi

# {"key":{"href":"https://us.api.blizzard.com/data/wow/connected-realm/4728?namespace=dynamic-classic-us"},"data":{"realms":[{"is_tournament":false,"timezone":"America/New_York","name":{"ru_RU":"Benediction","en_GB":"Benediction","zh_TW":"祈福","ko_KR":"Benediction","en_US":"Benediction","es_MX":"Benediction","pt_BR":"Benediction","es_ES":"Benediction","zh_CN":"祈福","fr_FR":"Benediction","de_DE":"Benediction"},"id":4728,"region":{"name":{"ru_RU":"Classic (Северная Америка)","en_GB":"Classic North America","zh_TW":"經典北美","ko_KR":"클래식 미국","en_US":"Classic North America","es_MX":"Classic Norteamérica","pt_BR":"Classic - América do Norte","es_ES":"Classic Norteamérica","zh_CN":"经典怀旧（北美）","fr_FR":"Classic Amérique du Nord","de_DE":"Classic - Nordamerika"},"id":41},"category":{"ru_RU":"США(восток)","en_GB":"US East","zh_TW":"美東","ko_KR":"미국 동부","en_US":"US East","es_MX":"EE. UU. este","pt_BR":"EUA - Leste","es_ES":"EE. UU. (Este)","zh_CN":"美国东部","fr_FR":"USA (Est)","de_DE":"USA Ost"},"locale":"enUS","type":{"name":{"ru_RU":"PvP","en_GB":"PvP","zh_TW":"PvP","ko_KR":"전쟁","en_US":"PvP","es_MX":"JcJ","pt_BR":"JxJ","es_ES":"JcJ","zh_CN":"PvP","fr_FR":"JcJ","de_DE":"PvP"},"type":"PVP"},"slug":"benediction"}],"id":4728,"has_queue":false,"status":{"name":{"ru_RU":"Работает","en_GB":"Up","zh_TW":"正常","ko_KR":"정상","en_US":"Up","es_MX":"Disponible","pt_BR":"Para Cima","es_ES":"Activo","zh_CN":"正常","fr_FR":"En ligne","de_DE":"Verfügbar"},"type":"UP"},"population":{"name":{"ru_RU":"Нет мест","en_GB":"Full","zh_TW":"滿","ko_KR":"정원초과","en_US":"Full","es_MX":"Lleno","pt_BR":"Completo","es_ES":"Lleno","zh_CN":"满","fr_FR":"Complet","de_DE":"Voll"},"type":"FULL"}}}

# api_client = BlizzardApi("128b217bf4744535aa007038eddf7d57", "JnuI8TrUExvVpCr7fNoYOAU2gRoYh6LT ") # move to a .env if deploying?

# # # Unprotected API endpoint
# # categories_index = api_client.wow.game_data.get_achievement_categories_index("us", "en_US")

# # # Protected API endpoint
# # summary = api_client.wow.profile.get_account_profile_summary("us", "en_US", "access_token")

# # Wow Classic endpoint
# connected_realms_index = api_client.wow.game_data.get_connected_realms_index("us", "en_US", is_classic=True)

# curl -u 128b217bf4744535aa007038eddf7d57:JnuI8TrUExvVpCr7fNoYOAU2gRoYh6LT -d grant_type=client_credentials https://us.battle.net/oauth/token

# curl -H "Authorization: Bearer USCL2xaJT5yX6gYPhrqlj3zDL5ENI97B2o" https://us.api.blizzard.com/data/wow/connected-realm/4372/auctions/2?namespace=dynamic-classic-us&locale=en_US&item=19019&access_token=USCL2xaJT5yX6gYPhrqlj3zDL5ENI97B2o


# curl -H "Authorization: Bearer USCL2xaJT5yX6gYPhrqlj3zDL5ENI97B2o" https://us.api.blizzard.com/data/wow/search/connected-realm?namespace=dynamic-classic-us&realms.name.en_US=benediction&access_token=USCL2xaJT5yX6gYPhrqlj3zDL5ENI97B2o


# /data/wow/search/connected-realm?namespace=dynamic-us&has_queue=true
# https://us.api.blizzard.com/data/wow/search/connected-realm?namespace=dynamic-us&has_queue=true

# https://us.api.blizzard.com/data/wow/connected-realm/4372/auctions/2?namespace=dynamic-classic-us&locale=en_US&access_token=USCL2xaJT5yX6gYPhrqlj3zDL5ENI97B2o

# load_dotenv('.env')

# 27666

# dict = {
# "_links": {
#     "self": {
#     "href": "https://us.api.blizzard.com/data/wow/connected-realm/4372/auctions/2?namespace=dynamic-classic-us"
#     }
# },
# "connected_realm": {
#     "href": "https://us.api.blizzard.com/data/wow/connected-realm/4372?namespace=dynamic-classic-us"
# },
# "auctions": [
#     {
#     "id": 1206760457,
#     "item": {
#         "id": 11290
#     },
#     "bid": 13110,
#     "buyout": 13800,
#     "quantity": 1,
#     "time_left": "SHORT"
#     },
#     {
#     "id": 1206760457,
#     "item": {
#         "id": 11290
#     },
#     "bid": 13110,
#     "buyout": 13800,
#     "quantity": 1,
#     "time_left": "SHORT"
#     },
#     {
#     "id": 1206760457,
#     "item": {
#         "id": 11290
#     },
#     "bid": 13110,
#     "buyout": 13800,
#     "quantity": 1,
#     "time_left": "SHORT"
#     },
#     ],
# "id": 2,
# "name": "Alliance Auction House"
# }

# if dict["auctions"][0]["item"]["id"] == 11290:
#     print("yes")
#     # print(dict["auctions"]["bid"])

# print(dict["auctions"][0]["bid"])
# print(dict['auctions'],['id'])

# for item in dict['auctions']:
#     if item['item']['id'] == 11290:
#         print(item['buyout'] / 10000)


# pairs = [   (key, value) 
#             for key, values in dict.items() 
#             for value in values ]
            
# for pair in pairs:
#     print(pair)



results = {
  "_links": {
    "self": {
      "href": "https://us.api.blizzard.com/data/wow/realm/?namespace=dynamic-classic-us"
    }
  },
  "realms": [
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4372?namespace=dynamic-classic-us"
      },
      "name": "Atiesh",
      "id": 4372,
      "slug": "atiesh"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4373?namespace=dynamic-classic-us"
      },
      "name": "Myzrael",
      "id": 4373,
      "slug": "myzrael"
    },
    {
    "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4374?namespace=dynamic-classic-us"
    },
    "name": "Old Blanchy",
    "id": 4374,
    "slug": "old-blanchy"
    },
    {
    "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4376?namespace=dynamic-classic-us"
    },
    "name": "Azuresong",
    "id": 4376,
    "slug": "azuresong"
    },
    {
    "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4384?namespace=dynamic-classic-us"
    },
    "name": "Mankrik",
    "id": 4384,
    "slug": "mankrik"
    },
    {
    "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4385?namespace=dynamic-classic-us"
    },
    "name": "Pagle",
    "id": 4385,
    "slug": "pagle"
    },
    {
    "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4386?namespace=dynamic-classic-us"
    },
      "name": "Deviate Delight",
      "id": 4386,
      "slug": "deviate-delight"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4387?namespace=dynamic-classic-us"
      },
      "name": "Ashkandi",
      "id": 4387,
      "slug": "ashkandi"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4388?namespace=dynamic-classic-us"
      },
      "name": "Westfall",
      "id": 4388,
      "slug": "westfall"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4395?namespace=dynamic-classic-us"
      },
      "name": "Whitemane",
      "id": 4395,
      "slug": "whitemane"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4396?namespace=dynamic-classic-us"
      },
      "name": "Fairbanks",
      "id": 4396,
      "slug": "fairbanks"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4397?namespace=dynamic-classic-us"
      },
      "name": "Blaumeux",
      "id": 4397,
      "slug": "blaumeux"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4398?namespace=dynamic-classic-us"
      },
      "name": "Bigglesworth",
      "id": 4398,
      "slug": "bigglesworth"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4399?namespace=dynamic-classic-us"
      },
      "name": "Kurinnaxx",
      "id": 4399,
      "slug": "kurinnaxx"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4406?namespace=dynamic-classic-us"
      },
      "name": "Herod",
      "id": 4406,
      "slug": "herod"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4407?namespace=dynamic-classic-us"
      },
      "name": "Thalnos",
      "id": 4407,
      "slug": "thalnos"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4408?namespace=dynamic-classic-us"
      },
      "name": "Faerlina",
      "id": 4408,
      "slug": "faerlina"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4409?namespace=dynamic-classic-us"
      },
      "name": "Stalagg",
      "id": 4409,
      "slug": "stalagg"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4410?namespace=dynamic-classic-us"
      },
      "name": "Skeram",
      "id": 4410,
      "slug": "skeram"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4647?namespace=dynamic-classic-us"
      },
      "name": "Grobbulus",
      "id": 4647,
      "slug": "grobbulus"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4648?namespace=dynamic-classic-us"
      },
      "name": "Bloodsail Buccaneers",
      "id": 4648,
      "slug": "bloodsail-buccaneers"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4649?namespace=dynamic-classic-us"
      },
      "name": "US1 CWOW Web",
      "id": 4649,
      "slug": "us1-cwow-web"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4651?namespace=dynamic-classic-us"
      },
      "name": "US2 CWOW Web",
      "id": 4651,
      "slug": "us2-cwow-web"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4653?namespace=dynamic-classic-us"
      },
      "name": "US1 CWOW GMSS 1",
      "id": 4653,
      "slug": "us1-cwow-gmss-1"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4654?namespace=dynamic-classic-us"
      },
      "name": "US1 CWOW GMSS 2",
      "id": 4654,
      "slug": "us1-cwow-gmss-2"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4667?namespace=dynamic-classic-us"
      },
      "name": "Remulos",
      "id": 4667,
      "slug": "remulos"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4669?namespace=dynamic-classic-us"
      },
      "name": "Arugal",
      "id": 4669,
      "slug": "arugal"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4670?namespace=dynamic-classic-us"
      },
      "name": "Yojamba",
      "id": 4670,
      "slug": "yojamba"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4695?namespace=dynamic-classic-us"
      },
      "name": "Rattlegore",
      "id": 4695,
      "slug": "rattlegore"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4696?namespace=dynamic-classic-us"
      },
      "name": "Smolderweb",
      "id": 4696,
      "slug": "smolderweb"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4698?namespace=dynamic-classic-us"
      },
      "name": "Incendius",
      "id": 4698,
      "slug": "incendius"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4699?namespace=dynamic-classic-us"
      },
      "name": "Kromcrush",
      "id": 4699,
      "slug": "kromcrush"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4700?namespace=dynamic-classic-us"
      },
      "name": "Kirtonos",
      "id": 4700,
      "slug": "kirtonos"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4714?namespace=dynamic-classic-us"
      },
      "name": "Thunderfury",
      "id": 4714,
      "slug": "thunderfury"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4715?namespace=dynamic-classic-us"
      },
      "name": "Anathema",
      "id": 4715,
      "slug": "anathema"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4716?namespace=dynamic-classic-us"
      },
      "name": "Arcanite Reaper",
      "id": 4716,
      "slug": "arcanite-reaper"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4726?namespace=dynamic-classic-us"
      },
      "name": "Sulfuras",
      "id": 4726,
      "slug": "sulfuras"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4727?namespace=dynamic-classic-us"
      },
      "name": "Windseeker",
      "id": 4727,
      "slug": "windseeker"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4728?namespace=dynamic-classic-us"
      },
      "name": "Benediction",
      "id": 4728,
      "slug": "benediction"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4729?namespace=dynamic-classic-us"
      },
      "name": "Netherwind",
      "id": 4729,
      "slug": "netherwind"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4731?namespace=dynamic-classic-us"
      },
      "name": "Earthfury",
      "id": 4731,
      "slug": "earthfury"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4732?namespace=dynamic-classic-us"
      },
      "name": "Heartseeker",
      "id": 4732,
      "slug": "heartseeker"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4737?namespace=dynamic-classic-us"
      },
      "name": "Sul'thraze",
      "id": 4737,
      "slug": "sulthraze"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4739?namespace=dynamic-classic-us"
      },
      "name": "Felstriker",
      "id": 4739,
      "slug": "felstriker"
    },
    {
      "key": {
        "href": "https://us.api.blizzard.com/data/wow/realm/4801?namespace=dynamic-classic-us"
      },
      "name": "Loatheb",
      "id": 4801,
      "slug": "loatheb"
    }
  ]
}
resultsList = []

for realm in results["realms"]:
    resultsList.append([realm["name"], realm["id"]])

print(resultsList)
