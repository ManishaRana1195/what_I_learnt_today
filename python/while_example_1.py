#!/usr/bin/python

# number to find the factorial of
number = 7

product = 1

current = number

while current > 0:
    product *= current
    current = current - 1
   
print("factorial of {} is {}.".format(number,product))

fact = 1;
for num in range(1, number+1):
     fact *= num

print("factorial of {} is {}.".format(number,fact))

