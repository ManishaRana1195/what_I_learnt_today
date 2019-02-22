### Text Editor

Before implementing text editor, we need to understand terminal in raw mode and cooked mode. Generally, text editors are in cooked mode, also known as canonical mode. A terminal mode is set of possible states of terminal and specifies how characters written to the terminal are interpreted.  
In raw mode, characters(input) is given as-is to the program, without interpreting any special characters.  
In cooked mode, the terminal interprets special characters in the input and gets the special meaning. Here, the characters are buffered internally until enter or return is pressed on the terminal.

#### Control Sequence Introducer 
ANSI escape sequences are used to control cursor location and color in text terminals. Most commands starting with escape or "^[" or "\e" are embedded into the text which terminal understands as commands, not character code.
"^[" OR "\e" character is known as CSI, which introduces the upcoming control sequence. CSI is of the form "\e1;2;3", where 1,2,3 are sequences as parameters. Most useful control sequences are as follows:

"\e2J" - clears the entire screen
"\e[10;10H" - moves the cursor to 10,10 location

#### Difference between "\n" and "\r\n"
If you enter two lines "foo\nbar" as input, the output would be
foo
   bar

"\r" escape sequence ensures that the cursor resets to the beginning of the line. So the output for "foo\r\nbar" would be
foo
bar 
