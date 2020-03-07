package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;

public class Response {

    private final HttpExchange exchange;
    private final int code;
    private String body = "";
    private String contentType = "text/html";

    Response(HttpExchange exchange, int code) {
        this.exchange = exchange;
        this.code = code;
    }

    public Response addHeader(String key, String value) {
        exchange.getResponseHeaders().add(key, value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public Response setBody(String body) {
        this.body = body;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public Response setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
