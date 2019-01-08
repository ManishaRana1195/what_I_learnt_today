
output_file = open("scribble_pad.txt","w")
output_file.write("I am teapot!!\n I do nothing!!\n")
output_file.write("May be I should do something.")
output_file.close()


input_file = open("scribble_pad.txt","r")
print(input_file.read())
input_file.close()



