package http.transaction;

import java.net.URL;

public class HttpRequest {
    HttpMethod httpMethod;
    URL url;
    String httpVersion;
    HttpHeaders httpHeaders;
    String httpContents;
    String[] queries;
    String path;



    public HttpRequest(HttpMethod httpMethod,
                       URL url,
                       String httpVersion,
                       HttpHeaders httpHeaders,
                       String httpContents) {
        this.httpMethod = httpMethod;
        this.url = url;
        this.httpVersion = httpVersion;
        this.httpHeaders = httpHeaders;
        this.httpContents = httpContents;
        this.path = url.getPath();
        try {
            this.queries = url.getQuery().split("&");
        }catch (Exception e){}
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public URL getUrl() {
        return url;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public String getHttpContents() {
        return httpContents;
    }

    public String[] getQueries() {
        return queries;
    }

    public String getPath() {
        return path;
    }
}
