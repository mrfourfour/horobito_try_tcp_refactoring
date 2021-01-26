package http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSocket {

    private final ServerSocket serverSocket;
    private final Socket socket;


    public HttpSocket(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("서버 소켓 생성");
        this.socket = serverSocket.accept();
        System.out.println("연결 성공");
    }

    public Socket getSocket() {
        return socket ;
    }
}
