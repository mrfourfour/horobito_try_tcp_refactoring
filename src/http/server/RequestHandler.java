package http.server;

import http.transaction.HttpHeaders;
import http.transaction.HttpMethod;
import http.transaction.HttpRequest;
import http.transaction.HttpResponse;

import java.io.IOException;
import java.net.URL;

public class RequestHandler {
    HttpMethod httpMethod;
    URL url;
    String httpVersion;
    HttpHeaders httpHeaders;
    String httpContnets;
    String path;
    String[] queries;



    public void handle(HttpRequest request, HttpResponse response) throws IOException {
        this.httpMethod = request.getHttpMethod();
        this.url = request.getUrl();
        this.httpVersion = request.getHttpVersion();
        this.httpHeaders = request.getHttpHeaders();
        this.httpContnets = request.getHttpContents();
        this.path = request.getPath();
        this.queries = request.getQueries();
        processRequest(response);

    }

    private synchronized void processRequest( HttpResponse response) throws IOException {
        if (httpMethod.equals(HttpMethod.POST)){
            post(response);
        }else if(httpMethod.equals(HttpMethod.GET)){
            get(response);
        }
    }

    private void get(HttpResponse response) throws IOException {
        if (path.equals("/profile")){ // 요거 어떵 처리하지..
            HandleProfile.setProfiles(response, queries);
        }else if(path.equals("/")){
            HelloWorld.setBodyHello(response);
        }
        response.setHttpHeaders("text/html");
    }

    private  void post(HttpResponse response) throws IOException {
        if(path.equals("/calculator")){
            Calculator.add(response, queries);
            response.setHttpHeaders("text/html");
        }
    }



}
