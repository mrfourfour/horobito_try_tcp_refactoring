package http.server;

import http.transaction.HttpResponse;

public class HelloWorld {

    public static void setBodyHello(HttpResponse response){
        response.setBody("wow wow wow??");
    }
}
