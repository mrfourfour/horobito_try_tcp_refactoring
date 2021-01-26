package http.server;

import http.transaction.HttpHeaders;
import http.transaction.HttpMethod;
import http.transaction.HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;


public class HttpMessageConverter {


    public HttpRequest parse(BufferedReader br, String address) throws IOException {
        String[] methodAndUrlAndVersion = br.readLine().split(" ");
        HttpMethod httpMethod = HttpMethod.valueOf(methodAndUrlAndVersion[0]);
        URL url = new URL(address+methodAndUrlAndVersion[1]);
        String httpVersion = methodAndUrlAndVersion[2];
        HttpHeaders httpHeaders = new HttpHeaders(br);
        String httpContents = extractContents(br, httpMethod);

        return new HttpRequest(
                httpMethod,
                url,
                httpVersion,
                httpHeaders,
                httpContents
        );

    }

    private String extractContents(BufferedReader br, HttpMethod httpMethod) throws IOException {
        String line = "";
        String content = "";

        if (httpMethod !=HttpMethod.GET){
            while ((line=br.readLine())!=null){
                content += line;
            }
        }
        return content;
    }
}
