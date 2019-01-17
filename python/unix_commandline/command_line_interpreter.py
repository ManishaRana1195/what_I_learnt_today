import os
from os import environ


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
bg = "bg"
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


def get_path_to_command(args):
    path_concatenated = environ['PATH']
    path_list = map(lambda x: "{}/{}".format(x, args[0]), path_concatenated.split(":"))

    valid_command_path = list(filter(lambda path: os.access(path, os.X_OK), path_list))
    if len(valid_command_path) == 0:
        print("couldn't find the command")
    else:
        return valid_command_path


def main():
    user_input = input("Enter command>>>").strip()
    running_processes = []
    is_background_process = False
    if user_input.startswith(bg):
        is_background_process = True;

    args = user_input.split(" ")
    if is_built_in(user_input):
        handle_built_in_commands(user_input, running_processes)
    else:
        valid_command_path = get_path_to_command(args)
        print(valid_command_path)
        if os.fork() == 0:
            print("in child")
        else:
            print("in parent")


if __name__ == "__main__":
    main()
