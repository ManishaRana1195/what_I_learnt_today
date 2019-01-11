import os


def change_directory_command(input_command):
    print("current path: {} ".format(os.getcwd()))

    cd_index = input_command.find(cd)
    path = input_command[cd_index+len(cd):]
    #print(path)
    try:
        os.chdir(path.strip())
    except OSError:
        print("cd: No such directory")

    print("current path: {} ".format(os.getcwd()))


def exit_command(input_command):
    print("exit !!")


def processes_command(input_command):
    print("processes")


cd = "cd"
exiting = "exit"
processes = "processes"
built_in_commands = {cd: change_directory_command, exiting: exit_command, processes: processes_command}


def handle_built_in_commands(input_command):
    for command in built_in_commands.keys():
        if input_command.startswith(command):
            built_in_commands[command](input_command)


def is_built_in(input_command):
    for command in built_in_commands.keys():
        if input_command.startswith(command):
            return True
    return False


def main():
    user_input = input("Enter command>>>").strip()
    if is_built_in(user_input):
        handle_built_in_commands(user_input)


if __name__ == "__main__":
    main()