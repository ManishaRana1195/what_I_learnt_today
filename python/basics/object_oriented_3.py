class Song(object):
    """ Class to represent a song

    Attributes:
        title(str): The title of the song
        artist(Artist) : The Artist object
        duration(int): The duration in seconds
    """
    def __init__(self, title, artist, duration=0):
        """ Song init method

        :param title: Initialises title
        :param artist: Initialises artist
        :param duration:
        """
        self.title = title
        self.artist = artist
        self.duration = duration
