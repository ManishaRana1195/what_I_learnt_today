
def change_directory_command(input_command):
    print("changing directory")


def exit_command(input_command):
    print("exit !!")


def processes_command(input_command):
    print("processes")


built_in_commands = {"cd": change_directory_command, "exit": exit_command, "processes": processes_command }


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