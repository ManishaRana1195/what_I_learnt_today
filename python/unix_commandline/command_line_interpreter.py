import os


def change_directory_command(input_command):
    print("current path: {} ".format(os.getcwd()))

    cd_index = input_command.find(cd)
    path = input_command[cd_index + len(cd):]
    try:
        os.chdir(path.strip())
    except OSError:
        print("cd: No such directory")

    print("current path: {} ".format(os.getcwd()))


def exit_command(running_processes):
    print("exit !!")


def processes_command(running_processes):
    for process in running_processes:
        print("background process with pid {} running".format(process))
    print("processes")


cd = "cd"
exiting = "exit"
processes = "processes"
built_in_commands = {cd: change_directory_command, exiting: exit_command, processes: processes_command}


def handle_built_in_commands(input_command, running_processes):
    if input_command.startswith(cd):
        built_in_commands[cd](input_command)
    elif input_command.startswith(exiting):
        built_in_commands[exiting](running_processes)
    elif input_command.startswith(processes):
        built_in_commands[exiting](running_processes)


def is_built_in(input_command):
    for command in built_in_commands.keys():
        if input_command.startswith(command):
            return True
    return False


def main():
    user_input = input("Enter command>>>").strip()
    running_processes = []
    if is_built_in(user_input):
        handle_built_in_commands(user_input, running_processes)


if __name__ == "__main__":
    main()
