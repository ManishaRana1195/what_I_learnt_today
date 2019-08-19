locations = {0: "You are sitting in", 1: "You are standing on the road",
             2: "you are at the top of a building", 3: "you are inside a building", 4: "you are in a valley",
             5: "you are in a forest"}

exits = [{"Q": 0},
         {"W": 2, "E": 3, "N": 5, "S": 4, "Q": 0},
         {"N": 5, "Q": 0},
         {"W": 1, "Q": 0},
         {"N": 1, "W": 2, "Q": 0},
         {"W": 2, "S": 1, "Q": 0}]

loc = 1
while True:
    available_exits = ", ".join(exits[loc].keys())

    print(locations[loc])

    if loc == 0:
        break

    print("Available exits: {}".format(available_exits))
    inputDir = input("Enter the direction you want to move in:").upper()

    if inputDir in exits[loc]:
        loc = exits[loc][inputDir]
    else:
        print("You cannot proceed in that direction")
