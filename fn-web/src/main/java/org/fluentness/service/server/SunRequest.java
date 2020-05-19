package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SunRequest implements Request {

    protected final HttpExchange exchange;
    protected final RequestMethod method;
    protected final URI uri;
    protected final Headers headers;
    protected final InputStream body;
    private final Map<String, String> getParameters;

    public SunRequest(HttpExchange exchange) {
        method = RequestMethod.valueOf(exchange.getRequestMethod());
        uri = exchange.getRequestURI();
        headers = exchange.getRequestHeaders();
        body = exchange.getRequestBody();
        this.exchange = exchange;
        getParameters = extractGetParameters();
    }

    private Map<String, String> extractGetParameters() {
        Map<String, String> result = new HashMap<>();
        String query = getUri().getQuery();
        if (query == null || query.isEmpty()) {
            return result;
        }
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    @Override
    public RequestMethod getMethod() {
        return method;
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public URI getUri() {
        return uri;
    }

    @Override
    public boolean hasParameter(String name) {
        return getParameters.containsKey(name);
    }

    @Override
    public String getParameter(String name) {
        return getParameters.get(name);
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
