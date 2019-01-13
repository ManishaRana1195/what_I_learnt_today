# prints false value in
print(""" False values:
    False: {0}
    None: {1}
    0 : {2}
    0.0 : {3}
    empty list [] : {4}
    empty tuple () : {5}
    empty string '' : {6}
    empty string "" : {7}
    empty mapping {{}} : {8}
""".format(False, bool(None), bool(0), bool(0.0), bool([]), bool(()), bool(''), bool(""), bool({})))

for i in range(1, 11):
    for j in range(1, 11):
        print("{} * {} = {} ".format(j, i, i * j), end="\t")
    print()

name = input("Enter your name:")
age = int(input("Enter your age:"))

if 18 < age < 31:
    print("{}, You are welcome to the holiday party".format(name))
else:
    print("You are not eligible for the holiday")
