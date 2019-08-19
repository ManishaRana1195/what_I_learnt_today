# dictionary and set data types are unordered, thus indexing elements does not make sense
#  and make sure the elements are unique
# dictionary keys must be immutable so list cannot be the key
fruit = {"apple": "good for making apple cider", "lemon": "a sour ", "grape": "used to make wine"}

for key, val in fruit.items():
    print(" {} : {} ".format(key, val))
print(fruit["grape"])
print(fruit.get("grape"))  # avoids keyerror

del fruit["grape"]
print(fruit)

fruit.keys()
fruit.values()

print(tuple(fruit))
# tuple() to create tuple from dictionary
# dict() to get dictionary from tuple

fruit.clear()  # removes the dictionary key-val pairs
del fruit  # deletes the fruit
