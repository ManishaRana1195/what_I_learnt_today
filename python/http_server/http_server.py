import socket


class Connection(object):

    def __init__(self, conn_sock):
        self.conn_sock = conn_sock
        self.buffer = ""

    def read_line(self):
        separator = "\r\n"
        while separator not in self.buffer:
            # to utf-8 decoding to remove b''
            self.buffer += str(self.conn_sock.recv(7), 'utf-8')

        result, self.buffer = self.buffer.split(separator, 2)
        return result

    def read_request(self):
        request_line = self.read_line()
        method, path, version = request_line.split("/", 3)
        headers = {}
        while True:
            line = self.read_line()
            if not line:
                break
            print(line)
            header, value = line.split(':', maxsplit=1)
            headers[header] = value

        print(headers)


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
    client_conn.read_request()


if __name__ == "__main__":
    main()
