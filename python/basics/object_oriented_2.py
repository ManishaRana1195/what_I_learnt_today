import datetime
import pytz


class Account(object):
    withdraw_action = "withdrawn"
    deposit_action = "deposited"

    @staticmethod
    def _current_time():
        """
            creating static method in python
            starting private methods with single _ means method is not
            intended to be accessed outside the class.
        """
        utc_time = datetime.datetime.now()
        return pytz.utc.localize(utc_time)

    # new method is the constructor, used to
    # instantiate the class
    # def __new__(cls, *args, **kwargs):

    # self cannot be omitted like "this" in java
    # init method is to customize the object with values
    def __init__(self, name, balance):
        """
            data attributes are underscore to suggest that they are intended to be private
        """
        self._name = name
        self._balance = balance
        self._transaction_list = [(Account._current_time(), balance, "initial")]
        print("Account created for {}". format(name))

    def deposit(self, amount):
        if amount > 0:
            self._balance += amount
            self._transaction_list.append((Account._current_time(), amount, self.deposit_action))

    def withdraw(self, amount):
        if amount > 0 and (self._balance - amount) >= 0:
            self._balance -= amount
            self._transaction_list.append(
                (pytz.utc.localize(datetime.datetime.now()), amount * -1, self.withdraw_action))

    def show_balance(self):
        print(" Account balance: {} ".format(self._balance))

    def show_transactions(self):
        for date, amount, action in self._transaction_list:
            print(" {:5} {} on {} (local time was {} )".format(amount, action, date, date.astimezone()))


if __name__ == "__main__":
    mark = Account("Mark", 400)
    mark.show_balance()

    mark.deposit(200)
    mark.show_balance()
    mark.withdraw(500)
    mark.show_balance()

    mark.show_transactions()
