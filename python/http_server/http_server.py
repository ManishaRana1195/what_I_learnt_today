import socket


class Connection(object):

    def __init__(self, conn_sock):
        self.conn_sock = conn_sock
        self.buffer = ""

    def read_line(self):
        separator = "\r\n"
        print(self.buffer)
        while separator not in self.buffer:
            # to utf-8 decoding to remove b''
            self.buffer += str(self.conn_sock.recv(100), 'utf-8')

        return self.buffer
        #print(self.buffer.split(separator, 2))


def main():
    # AF_INET for internet socket
    # STREAM, not raw
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    sock.bind(("127.0.0.1", 4000))
    sock.listen(0)
    # accept blocks and waits for client request
    client_sock, address_info = sock.accept()
    client_conn = Connection(client_sock)
    client_conn.read_line()
    client_conn.read_line()
    client_conn.read_line()
    client_conn.read_line()


if __name__ == "__main__":
    main()
