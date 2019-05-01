package org.fluentness.server;


import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private int statusCode;
    private Map<String, String> headers = new HashMap<>();
    private String body = "";

    public HttpResponse(int statusCode) {
        this.statusCode = statusCode;
    }

    int getStatusCode() {
        return statusCode;
    }

    public HttpResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    Map<String, String> getHeaders() {
        return headers;
    }

    public HttpResponse setHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    String getBody() {
        return body;
    }

    public HttpResponse setBody(String body) {
        this.body = body;
        return this;
    }


}
