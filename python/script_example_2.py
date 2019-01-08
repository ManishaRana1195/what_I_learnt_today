
while True:
    try:
       num = int(input("Enter value:"))

    except ValueError as e:
       print("Input should be integer: {}".format(e))
    
    except KeyboardInterrupt as e:
       print("Interrupted by keyboard: {}".format(e))
       break
    finally:
       print("I will execute anyway")
