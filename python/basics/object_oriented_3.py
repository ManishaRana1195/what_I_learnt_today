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


# methods to display the docstring
# help(Song.__init__)
# print(Song.__doc__)
# print(Song.__init__.__doc__)

class Album(object):
    """
        Class to represent an Album
        Attributes:
            name(str): The name of the album
            year(int): year the album was released
            artist(Artist): The artist/creator of the album, defaults to
            "Various Artists"
            tracks(List[Song]): list of songs of album
    """

    def __init__(self, name, year, artist=None):
        self.name = name
        self.year = year
        self.tracks = []
        if artist is None:
            self.artist = Artist("Various Artists")
        else:
            self.artist = artist

    def add_song(self, song, position=None):
        """add song to the album

        :param song: song object in album
        :param position: the position is Optional. If position is not specified, song is appended
        :return:
        """
        if position is None:
            self.tracks.append(song)
        else:
            self.tracks.insert(position, song)


class Artist(object):
    """
        Class to represent artist details

        Attributes:
            name (str): artist name
            albums (List[albums]): list of albums published by this artist
    """

    def __init__(self, name):
        self.name = name
        self.albums = []

    def add_album(self, album):
        self.albums.append(album)


# These set of classes have cyclic dependency, we should avoid such schema

def load_artist_data():
    new_artist = None
    new_album = None
    artist_list = []

    with open("../albums.txt", "r") as albums:
        for line in albums:
            artist_val, album_val, year_val, song_val = tuple(line.strip("\n").split("\t"))
            print(artist_val, album_val, year_val, song_val)



if __name__ == "__main__":
    load_artist_data()
