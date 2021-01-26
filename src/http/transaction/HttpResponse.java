package http.transaction;

import java.io.IOException;

public class HttpResponse {

    private String httpVersion;
    private HttpStatus httpStatus;
    private HttpHeaders httpHeaders;
    private String body;


    public String getHttpVersion() {
        return httpVersion;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public HttpHeaders getHttpHeaders() {
        return httpHeaders;
    }

    public String getBody() {
        return body;
    }

    public void setHttpVersion(String httpVersion) {
        this.httpVersion = httpVersion;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public void setHttpHeaders(String contentType) throws IOException {
        this.httpHeaders = new HttpHeaders();
        this.httpHeaders.setContentType(contentType);
    }

    public void setBody(String body) {
        this.body = body;
    }
}
