
try:
   num = int(input("Enter value:"))

except ValueError:
   print("Input should be integer")

finally:
  print("I will execute anyway")
