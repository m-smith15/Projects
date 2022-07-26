import discord
import os
from dotenv import load_dotenv
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

    if message.content.endswith('price'):
        await message.channel.send('the price is right')

client.run(os.getenv('TOKEN'))