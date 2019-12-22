package org.fluentness.service.server;

import com.sun.net.httpserver.HttpExchange;

public class Response {

    private final HttpExchange exchange;
    private final int code;
    private String body;

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


}
