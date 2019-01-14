class Kettle(object):

    power_source = "electricity"

    def __init__(self, make, price):
        self.make = make
        self.price = price
        self.on = False

    def __str__(self):
        return " make: {}, price: {}".format(self.make, self.price)

    def switch_on(self):
        self.on = True


kenwood = Kettle("Kenwood", 11.10)
print(kenwood)

hamilton = Kettle("hamilton", 12.10)
print(hamilton)

# Woww!!
print("Models: {0.make}= {0.price}, {1.make}= {1.price}".format(hamilton, kenwood))

# Amazing
Kettle.switch_on(hamilton)
print(hamilton.on)

# class variable

print(Kettle.power_source)

# power_source shadowing the class attribute
kenwood.power_source = "gas"
print(kenwood.power_source)
print(hamilton.power_source)


# Adding instance data attributes to instance as we like
kenwood.power = 2.5
print(kenwood.power)
print(hamilton.power)   # error no attribute on Kettle


