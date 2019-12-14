package org.fluentness.server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;

import java.io.InputStream;
import java.net.URI;
import java.util.Locale;

public class Request {

    private final HttpExchange exchange;
    private final String method;
    private final URI uri;
    private final Headers headers;
    private final InputStream body;

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

    public Response makeRedirect(WebAction action) {
        return new Response(exchange, 301).addHeader(
            "Location",
            action.getMethod().getAnnotation(AbstractWebController.Action.class).path()
        );

    }

    public Response makeRedirect(String url) {
        return new Response(exchange, 301).addHeader("Location", url);
    }
}
