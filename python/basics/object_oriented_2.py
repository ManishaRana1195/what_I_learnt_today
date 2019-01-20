class Account(object):

    # new method is the constructor, used to
    # instantiate the class
    # def __new__(cls, *args, **kwargs):

    # self cannot be omitted like "this" in java
    # init method is to customize the object with values
    def __init__(self, name, balance):
        self.name = name
        self.balance = balance

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount

    def withdraw(self, amount):
        if amount > 0 and (self.balance - amount) >= 0:
            self.balance -= amount

    def show_balance(self):
        print(" Account balance: {} ".format(self.balance))

if __name__ == "__main__":
    mark = Account("Mark", 400)
    mark.show_balance()

    mark.deposit(200)
    mark.show_balance()
    mark.withdraw(500)
    mark.show_balance()
