farm_animals = {"sheep", "cow", "goat"}
print(farm_animals)
print("*" * 30)

wild_animals = set(["lion", "tiger", "wolf", "jackal"])  # create from iterable object, range, tuple
print(wild_animals)

wild_animals.add("gorilla")
print(wild_animals)

even = set(range(4, 40, 2))
squares = {4, 9, 16, 25, 36, 49}

print("set union")
print(even.union(squares))
print("=" * 40)

# intersection
print("set intersection")
print(even.intersection(squares))
print(even & squares)
print("=" * 40)

# subtraction
print("set subtraction")
print(even.difference(squares))        # similar even.difference_update(squares)
print(even - squares)
print(squares.difference(even))


