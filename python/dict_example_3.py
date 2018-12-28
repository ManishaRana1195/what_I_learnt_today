#!/usr/bin/python

fruit_count, not_fruit_count = 0, 0
basket_items = {'apples': 4, 'oranges': 19, 'kites': 3, 'sandwiches': 8}
fruits = ['apples', 'oranges', 'pears', 'peaches', 'grapes', 'bananas']

#keeping count of fruits and not fruits in basket
for item,count in basket_items.items():
    if item not in fruits:
        not_fruit_count += count
    else:
        fruit_count += count


print(fruit_count, not_fruit_count)
