package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SunRequest implements Request {

    protected final HttpExchange exchange;
    protected String method;
    protected URI uri;
    protected Headers headers;
    protected InputStream body;

    public SunRequest(HttpExchange exchange) {
        method = exchange.getRequestMethod();
        uri = exchange.getRequestURI();
        headers = exchange.getRequestHeaders();
        body = exchange.getRequestBody();
        this.exchange = exchange;
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public InputStream getBody() {
        return body;
    }

    @Override
    public Locale getLocale() {
        // todo implement
        return Locale.getDefault();
    }

    @Override
    public Response makeResponse(int code) {
        return new SunResponse(exchange, code);
    }
}
