package http.server;

import http.transaction.HttpRequest;
import http.transaction.HttpResponse;
import http.transaction.HttpStatus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    private final HttpConnection httpConnection;
    private final RequestHandler requestHandler;
    private final HttpMessageConverter httpMessageConverter;
    private final String address;
    private final HttpResultPrinter httpResultPrinter;


    public Server(int port, String address) throws IOException {
        this.httpConnection = new HttpConnection(port);
        this.requestHandler = new RequestHandler();
        this.httpMessageConverter = new HttpMessageConverter();
        this.address = address;
        this.httpResultPrinter = new HttpResultPrinter();
    }

    public void start() throws IOException {
        acceptRequest();
    }

    private synchronized void acceptRequest() throws IOException {

            Socket socket = httpConnection.getSocket();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            HttpRequest request = httpMessageConverter.parse(br, address);
            HttpResponse response = handle(request);
            httpResultPrinter.print(response, socket);
            httpResultPrinter.closeBw();
            br.close();
            socket.close();

    }

    private HttpResponse handle(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        try {
            requestHandler.handle(request, response);
            response.setHttpVersion(request.getHttpVersion());
            response.setHttpStatus(HttpStatus.OK);
        }catch (Exception e){
            response.setBody("error error error");
            response.setHttpVersion(request.getHttpVersion());
            response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


}
