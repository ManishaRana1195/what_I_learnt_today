### Text Editor

Before implementing text editor, we need to understand terminal in raw mode and cooked mode. Generally, text editors are in cooked mode, also known as canonical mode. A terminal mode is set of possible states of terminal and specifies how characters written to the terminal are interpreted.  
In raw mode, characters(input) is given as-is to the program, without interpreting any special characters.  
In cooked mode, the terminal interprets special characters in the input and gets the special meaning. Here, the characters are buffered internally until enter or return is pressed on the terminal.

#### Command Sequence Initiator  
