package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.URI;
import java.util.Locale;

public class Request {

    protected HttpExchange exchange;
    protected String method;
    protected URI uri;
    protected Headers headers;
    protected InputStream body;

    public Request(HttpExchange exchange) {
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

    public Response response(int code) {
        return new Response(exchange, code);
    }
}
