package org.fluentness.controller;


import java.util.HashMap;
import java.util.Map;

public class Response {
    private int statusCode;
    private Map<String, String> headers = new HashMap<>();
    private String body = "";

    public Response(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Response setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Response setHeader(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }


}
