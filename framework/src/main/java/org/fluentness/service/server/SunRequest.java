package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class SunRequest implements Request {

    protected final HttpExchange exchange;
    protected final RequestMethod method;
    protected final URI uri;
    protected final Headers headers;
    protected final InputStream body;

    public SunRequest(HttpExchange exchange) {
        method = RequestMethod.valueOf(exchange.getRequestMethod());
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
    public RequestMethod getMethod() {
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
    public Response makeResponse(int code) {
        return new SunResponse(exchange, code);
    }
}
