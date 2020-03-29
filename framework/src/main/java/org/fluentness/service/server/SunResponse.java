package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

public class SunResponse implements Response {

    protected final HttpExchange exchange;
    protected final Headers headers;
    protected final int code;
    protected String body = "";

    SunResponse(HttpExchange exchange, int code) {
        this.exchange = exchange;
        this.code = code;
        this.headers = exchange.getResponseHeaders();
    }

    @Override
    public Headers getHeaders() {
        return headers;
    }

    @Override
    public Response addHeader(String key, String value) {
        headers.set(key, value);
        return this;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public Response setBody(String body) {
        this.body = body;
        return this;
    }

}
