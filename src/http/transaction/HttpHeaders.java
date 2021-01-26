package http.transaction;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpHeaders {
    private String headers;

    private String CONTENT_TYPE = "Content-Type";

    public HttpHeaders(){}

    public HttpHeaders(BufferedReader br) throws IOException {
        extractHeader(br);
    }

    public HttpHeaders(String contentType){
        this.CONTENT_TYPE += " " + contentType;
    }

    private void extractHeader(BufferedReader br) throws IOException {
        String line = "";
        while (!(line=br.readLine()).isBlank()){
            headers += line + " ";
        }
    }

    public void setContentType(String contentType) throws IOException {
        this.setCONTENT_TYPE(contentType);
    }

    public String getHeaders() {
        return headers;
    }

    public String getCONTENT_TYPE() {
        return CONTENT_TYPE;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setCONTENT_TYPE(String contentType) {
        this.CONTENT_TYPE += " : " +contentType;
    }
}
