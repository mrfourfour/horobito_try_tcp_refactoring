package http.server;

import java.io.IOException;
import java.net.Socket;

public class HttpConnection {
    private final Socket socket;



    public HttpConnection(int port) throws IOException {
        this.socket = new HttpSocket(port).getSocket();
    }

    public Socket getSocket() {
        return socket;
    }
}
