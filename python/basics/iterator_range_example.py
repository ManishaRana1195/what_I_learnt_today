array = ['b', 'l', 'a', 'a', 'h', 'b', 'u', 'r', 'r', 'a', 'h']

n = len(array)
arr_iter = iter(array)
while n != 0:
    print(next(arr_iter))
    n -= 1

# range returns a range object which takes minimum memory
# all the operation that are applicable to list, are applicable to range as well.

