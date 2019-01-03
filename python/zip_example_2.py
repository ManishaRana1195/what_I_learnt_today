#!/usr/bin/python

data = ((0, 1, 2), (3, 4, 5), (6, 7, 8), (9, 10, 11))

rows = zip(*data)
data_transpose = tuple(rows)
print(data_transpose)

