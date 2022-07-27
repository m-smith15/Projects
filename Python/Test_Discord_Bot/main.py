import discord
import os
from dotenv import load_dotenv
import datetime
load_dotenv('.env')

client = discord.Client()

@client.event
async def on_ready():
    print('We have logged in as {0.user}'.format(client))

@client.event
async def on_message(message):
    if message.author == client.user:
        return

    if message.content.startswith('$about'):
        await message.channel.send('We have logged in as {0.user} in {0.guilds}'.format(client))

    if message.content.startswith('hey guys its me yolt'):
        await message.channel.send('nice week 1 swp clear!')

    if message.content.startswith('hey guys its me gupi'):
        await message.channel.send('let me guess: PINCHY ALERT OMG!!!!!!!!')

    if message.content.startswith('hey guys its me jrollman123'):
        await message.channel.send('ijr')

    if message.content.endswith('price'):
        await message.channel.send('the price is right')
    
    if message.content.endswith('divinity') or message.content.startswith('divinity'):
        dCheck = message.created_at
        if dCheck < datetime.datetime(2022, 7, 27, 23, 0, 00):
            await message.channel.send('Not time yet')
        elif dCheck > datetime.datetime(2022,7,27, 23, 0, 00):
            await message.channel.send('TRYNA?!')


client.run(os.getenv('TOKEN'))