num = 5
x = eval('num* "Hey there!!"')
print(x)


names = input("Enter names(separated by ,):").split(",")
missing_assignments = input("Enter missing assignment count(separated by ,):").split(",")
current_grades = input("Enter current grades(separated by ,):").split(",")

message = "Hi {},\n\nThis is a reminder that you have {} assignments left to \
submit before you can graduate. You're current grade is {} and can increase \
to {} if you submit all assignments before the due date.\n\n"

for index,name in enumerate(names):
	increased_grade = int(current_grades[index])+ 2*int(missing_assignments[index])
	output = message.format(name,missing_assignments[index],current_grades[index],increased_grade)
	print(output)
