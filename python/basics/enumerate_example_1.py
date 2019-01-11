#!/usr/bin/python

letters = ['aero', 'bow', 'cart', 'dart','earn','foe']

for index, letter in zip(range(len(letters)), letters): 
	print ("{} at {} position".format(letter,index ))


cast = ["Barney Stinson", "Robin Scherbatsky", "Ted Mosby", "Lily Aldrin", "Marshall Eriksen"]
heights = [72, 68, 72, 66, 76]

for i, name in enumerate(cast):
    cast[i] = "{} {}".format(cast[i], heights[i])

print(cast)
