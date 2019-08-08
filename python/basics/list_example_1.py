#!usr/bin/python

cities = ["srinagar", "bengaluru", "montecarlo", "vatican", "cantt"]

names = [city.title() for city in cities]

names_with_if = [city.title() for city in cities if len(city) > 6]

names_with_if_else = [city.title() if len(city) > 6 else city.lower() for city in cities]

print(names)
print(names_with_if)
print(names_with_if_else)

# list the first names in lowercase
names = ["Rick Sanchez", "Morty Smith", "Summer Smith", "Jerry Smith", "Beth Smith"]

first_names = [name.split()[0].lower() for name in names]  # write your list comprehension here
print(first_names)

scores = {
    "Rick Sanchez": 70,
    "Morty Smith": 35,
    "Summer Smith": 82,
    "Jerry Smith": 23,
    "Beth Smith": 98
}
# list the names who scored atleast 65
passed = [name for name, score in scores.items() if score >= 65]
print(passed)

# sorted(list_variable) sorts the list and returns new list
# list_variable.sort() sorts the list but does not return any new list/variable
# For 2 lists to be equal in python(==), they should have same content and in same order.
