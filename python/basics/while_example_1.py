#!/usr/bin/python

# number to find the factorial of
number = 7
product = 1
current = number

while current > 0:
    product *= current
    current = current - 1

print("factorial of {} is {}.".format(number, product))

fact = 1
for num in range(1, number + 1):
    fact *= num

print("factorial of {} is {}.".format(number, fact))

ip_addresses = ["127.0.0.1", ".192.168.0.1", "172.16", "255", "10.0.13425.126", "10.10t.10", "..10.100"]

print("with split")
for ip_address in ip_addresses:
    segments = ip_address.split(".")
    print("{} segments in {} as {}".format(len(segments), ip_address, segments))

print("without split")
for ip_address in ip_addresses:
    segment_arr = []
    segment = ""
    char = ''
    
    for char in ip_address:
        if char == '.':
            segment_arr.append(segment)
            segment = ""
        else:
            segment += char
    if char != ".": # for last segment
        segment_arr.append(segment)

    print("{} segments in {} as {}".format(len(segment_arr), ip_address, segment_arr))
