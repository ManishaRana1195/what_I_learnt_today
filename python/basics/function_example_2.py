#!usr/bin/python

str1 = "This is my initial value"


def print_str():
    ### Here str1 is local variable, doing str1 += "" will give an error
    str1 = "I am going to replace the previous string"
    print(str1)

print_str()

numbers = [
              [34, 63, 88, 71, 29],
              [90, 78, 51, 27, 45],
              [63, 37, 85, 46, 22],
              [51, 22, 34, 11, 18]
           ]

### averages list of numbers 
averages = list(map( lambda num_list: sum(num_list) / len(num_list), numbers))
print(averages)

cities = ["New York City", "Los Angeles", "Chicago", "Mountain View", "Denver", "Boston"]
### filters city names on basis of length
short_cities = list(filter(lambda name: len(name) < 10, cities))
print(short_cities)
