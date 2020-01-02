package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.URI;
import java.util.Locale;

public class SunRequest {

    private final HttpExchange exchange;
    private final String method;
    private final URI uri;
    private final Headers headers;
    private final InputStream body;

    public SunRequest(HttpExchange exchange) {
        method = exchange.getRequestMethod();
        uri = exchange.getRequestURI();
        headers = exchange.getRequestHeaders();
        body = exchange.getRequestBody();
        this.exchange = exchange;
    }

    public String getMethod() {
        return method;
    }

    public URI getUri() {
        return uri;
    }

    public Headers getHeaders() {
        return headers;
    }

    public InputStream getBody() {
        return body;
    }

    public Locale getLocale() {
        // todo implement
        return Locale.getDefault();
    }

    public SunResponse response(int code) {
        return new SunResponse(exchange, code);
    }
}
