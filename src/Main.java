
import http.server.Server;

 import java.io.IOException;


 public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        String address = "http://localhost";
        start(port, address);

    }

    public static void start(int port, String address) throws IOException {
        Server server = new Server(port, address);
        server.start();
    }
}
