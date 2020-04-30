package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.util.List;
import java.util.Map;

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
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public Response addHeader(ResponseHeader key, String value) {
        headers.set(key.toString(), value);
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
