lessons = ["Why Python Programming", "Data Types and Operators", "Control Flow", "Functions", "Scripting"]

def my_enumerate(iterable, start=0):
    while start <= len(iterable):
        yield start,iterable[start-1]
        start += 1



for i, lesson in my_enumerate('python', 2):
    print("Lesson {}: {}".format(i, lesson))

for i, lesson in my_enumerate(lessons,1):
    print("Lesson {}: {}".format(i, lesson))



#to print a list in chunks
def chunker(iterable, size):
    start = 0
    while start < len(iterable):
        yield iterable[start:start+size]
        start += size



for chunk in chunker(range(25), 4):
    print(list(chunk))
