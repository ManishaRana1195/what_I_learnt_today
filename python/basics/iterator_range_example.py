array = ['b', 'l', 'a', 'a', 'h', 'b', 'u', 'r', 'r', 'a', 'h']

n = len(array)
arr_iter = iter(array)
while n != 0:
    print(next(arr_iter))
    n -= 1

# range is builtin type and returns a range object which takes minimum memory
# all the operation that are applicable to list, are applicable to range as well, for example, index(), slicing.

range_var = range(1, 100, 2)
sliced = range_var[5:50:2]  # returns new range
print(sliced)
print(range(0, 10, 2).index(4))

tuple1 = "a", "b", "c"  # with or without parenthesis, both are valid tuples
tuple2 = ("x", "y", "z")
print(tuple1)
print(tuple2)

# tuples are immutable, so you can not update values in tuple. You cannot append to tuple
#  Tuple is intended to store heterogeneous values in it.
# tuple2[0] = "hey"

# but you can assign new object to the tuple
tuple2 = ("hurray", "haha")
print(tuple2)

val_1, val_2 = tuple2
print("{}  {} ".format(val_1, val_2))

# tuple challenge
imelda = "More Mayhem", "Imelda Mayhem", 2011, ((1, "Pulling the rug"), (2, "Psycho"), (3, "Mayhem"))
album, name, year, tracks = imelda

print("{}: {}, {} with tracks ".format(name, album, year))
for track in tracks:
    print("\t {} ".format(track))

number = 65535
result = ""
while number != 0:
    result += str(number % 2)
    number = number // 2

print(result)
