#!/usr/bin/python

#Write a loop with a break statement to create a string, news_ticker, that is exactly 140 characters long.

headlines = ["Local Bear Eaten by Man",
             "Legislature Announces New Laws",
             "Peasant Discovers Violence Inherent in System",
             "Cat Rescues Fireman Stuck in Tree",
             "Brave Knight Runs Away",
             "Papperbok Review: Totally Triffic"]

news_ticker = ""
length = 0

for headline in headlines:
    length = len(news_ticker + headline )
    if length == 140:
        break
    if length > 140:
        chars = length - 140;
        #headline = headline[0:(len(headline) - chars)+1]
        news_ticker += headline
	news_ticker = news_ticker[0:140]
        break
    news_ticker += headline + " "
        

print(news_ticker)
