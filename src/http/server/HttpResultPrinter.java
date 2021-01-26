package http.server;

import http.transaction.HttpResponse;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResultPrinter {
    private String answer = "";
    private BufferedWriter bw;
    public void print(HttpResponse response, Socket socket) throws IOException {
        bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        answer += response.getHttpVersion()+"\r\n" +
                response.getHttpHeaders().getCONTENT_TYPE()+"\r\n\r\n"+
                response.getBody();
        bw.write(answer);
        bw.flush();

    }

    public void closeBw() throws IOException {
        this.bw.close();
    }


}
