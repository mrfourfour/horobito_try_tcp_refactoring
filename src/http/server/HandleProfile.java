package http.server;

import http.transaction.HttpResponse;

public class HandleProfile {

    public static void setProfiles(HttpResponse httpResponse, String[] queries){
        String profile = getProfile(queries);
        httpResponse.setBody("my name is " + profile );
    }

    public static String getProfile(String[] queries){
        String profile = queries[0].split("=")[1];
        return profile;
    }
}
