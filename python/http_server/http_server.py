import socket


class Connection(object):

    def __init__(self, conn_sock):
        self.conn_sock = conn_sock
        self.buffer = ""

    def read_line(self):
        while "\r\n" not in self.buffer:
            self.buffer += repr(self.conn_sock.recv(7))
            print(self.buffer)


def main():
    # AF_INET for internet socket
    # STREAM, not raw
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    sock.bind(("127.0.0.1", 4000))
    sock.listen(0)
    # accept blocks and waits for client request
    client_sock, address_info = sock.accept()
   # print(client_sock.recv(4096))
    Connection(client_sock).read_line()


if __name__ == "__main__":
    main()
