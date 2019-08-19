locations = {0: "You are sitting in", 1: "You are standing on the road",
             2: "you are at the top of a building", 3: "you are inside a building", 4: "you are in a valley",
             5: "you are in a forest"}

exits = {0: {"Q": 0},
         1: {"W": 2, "E": 3, "N": 5, "S": 4, "Q": 0},
         2: {"N": 5, "Q": 0},
         3: {"W": 1, "Q": 0},
         4: {"N": 1, "W": 2, "Q": 0},
         5: {"W": 2, "S": 1, "Q": 0}}

words = {"QUIT": "Q",
         "NORTH": "N",
         "SOUTH": "S",
         "EAST": "E",
         "WEST": "W"}

loc = 1
while True:
    available_exits = ", ".join(exits[loc].keys())

    print(locations[loc])

    if loc == 0:
        break

    print("Available exits: {}".format(available_exits))
    inputDir = input("Enter the direction you want to move in:")

    command = words.get(inputDir.upper())
    if command in exits[loc]:
        loc = exits[loc][inputDir]
    else:
        print("You cannot proceed in that direction")

exits.update(words)
print(exits)  # appends one dictionary to another, the changes are made inplace, doesnot return a new dictionary
new_dict = exits.copy(words)  # merges two dictionary and returns a new dictionary
print(new_dict)