# Character Template - Web Scraper
  - Here is the webscraper that I built from the ground up that uses a library called "Htmlunit" ([Read about it here](https://htmlunit.sourceforge.io/))

# The algorithm
  - I first built an Array that gathered all of the Spell Schools available on the wiki. Ex. Aerotheurge, Geomancer, Hydrosophist, etc.
    - This is done automatically from the "All Skills" page, and using XPath to traverse
  - Once the array of spell schools is built, I use that array in an algorithm that goes to each spell school page (ex: All Aerotheurge spells page) and gathers values (Memory, Action Points, Source Points, etc) at a specific xpath. The ArrayList that contains all of those values is then added to the mySQL DB.

# Why?
  - I built this from scratch so that I didn't have to populate the database myself!

# Challenges
  - One of the big challenges was that I was scraping information from a Wiki. The wiki is a community driven online resource that doesn't quite have uniform methods for presenting data in tables. To the human eye, no problem data is all there. For a program looking to scrape information at a specific point - it becomes challenging. 

# Closing
  - Overall, building this was a blast! Starting from nothing, doing research on libraries, and tweaking along the way was such a great learning experience. A huge thank you to the folks who built and maintained the [Divinity Original Sin 2 Wiki](https://divinityoriginalsin2.wiki.fextralife.com/Divinity+Original+Sin+2+Wiki) for having such a great resource (and for not blocking my IP while building this!).
