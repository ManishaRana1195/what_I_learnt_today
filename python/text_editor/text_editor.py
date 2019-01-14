class TextEditor(object):

    def __init__(self):
        try:
            with open("/home/manisharana/Downloads/abc.txt", 'r', encoding="utf-8") as f:
                lines = f.readlines()
        except FileNotFoundError:
            print("No such file or dir")


class Buffer(object):


class Cursor(object):


editor = TextEditor()
