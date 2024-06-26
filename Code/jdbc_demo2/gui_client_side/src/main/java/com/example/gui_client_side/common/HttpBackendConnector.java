package com.example.gui_client_side.common;

import okhttp3.*;

import java.io.IOException;

public class HttpBackendConnector {
    private static HttpBackendConnector instance;
    HttpBackendConnector() {

    }
    // Singleton
    public static synchronized HttpBackendConnector getInstance() {
        if (instance == null) {
            instance = new HttpBackendConnector();
        }
        return instance;
    }
    // Singleton

    static OkHttpClient client = new OkHttpClient();

    public Response send(String body, String url) {
        RequestBody formattedBody = RequestBody.create(
                body, MediaType.parse("application/json; " +
                        "charset=utf-8"));


        Request request = new Request.Builder()
                .url(String.format("http://127.0.0.1:5000/" + url))
                .post(formattedBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
