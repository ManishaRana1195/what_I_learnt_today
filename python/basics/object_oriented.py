class Kettle(object):

    def __init__(self, make, price):
        self.make = make
        self.price = price
        self.on = False

    def __str__(self):
        return " make: {}, price: {}".format(self.make, self.price)


kenwood = Kettle("Kenwood", 11.10)
print(kenwood)

hamilton = Kettle("hamilton", 12.10)
print(hamilton)