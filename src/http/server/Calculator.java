package http.server;

import http.transaction.HttpResponse;

public class Calculator {

    public static void add(HttpResponse httpResponse, String[] queries){
        String answer = "";
        Integer a = Integer.parseInt(queries[0].split("=")[1]);
        Integer b = Integer.parseInt(queries[1].split("=")[2]);
        answer = Integer.toBinaryString(a+b);
        httpResponse.setBody(answer);
    }

}
