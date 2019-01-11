
output_file = open("scribble_pad.txt","w")
output_file.write("I am teapot!!\nI do nothing!!\n")
output_file.write("May be I should do something.")
output_file.close()


input_file = open("scribble_pad.txt","r")
print(input_file.read())
input_file.close()


with open("scribble_pad.txt",'r') as f:
   print("Read by number of characters")
   print(f.read(5))
   print(f.read())
 
with open("scribble_pad.txt", 'a') as f:  
   f.write("""
    I've been commuting to work on my bicycle. 
    I've always been a walker, but I've been out of shape and slowly gaining fat for some time now. 
    The new activity has led to some obvious weight loss. 
    This has inspired me to keep working at it and track my progress.
    """)

with open("scribble_pad.txt", 'r') as f:  
   print("Reading file after seek:")
   f.seek(50)
   print(f.read(5))
   f.seek(100)
   print(f.read(5))




