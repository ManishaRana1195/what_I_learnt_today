# hr - list comprehension
# https://www.hackerrank.com/challenges/list-comprehensions/problem
if __name__ == '__main__':
    x = int(input("Enter integer x:"))
    y = int(input("Enter integer y:"))
    z = int(input("Enter integer z:"))
    n = int(input("Enter integer n:"))

    result = [[i, j, k] for i in range(x + 1) for j in range(y + 1) for k in range(z + 1) if (i + j + k) != n]
    print(result)

#hr - Nested Lists
#https://www.hackerrank.com/challenges/nested-list/problem

score_list = []
result = []
for _ in range(int(input("Number of records:"))):
    name = input("Enter name:")
    score = float(input("Enter score:"))
    score_list.append([name, score])

score_list = sorted(score_list, key=lambda values: values[1])
minimum = score_list[0][1]
second_min = 0

for score in score_list:
    if score[1] > minimum:
        second_min = score[1]
        break

result = [score[0] for score in score_list if second_min == score[1]]

print("The second highest score:")
for name in sorted(result):
    print(name)

