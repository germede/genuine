package org.fluentness.service.server;

import fi.iki.elonen.NanoHTTPD;

import java.io.InputStream;
import java.util.Map;

public class RequestImpl implements Request {

    private final NanoHTTPD.IHTTPSession session;

    public RequestImpl(NanoHTTPD.IHTTPSession session) {
        this.session = session;
    }

    @Override
    public String getMethod() {
        return session.getMethod().toString();
    }

    @Override
    public String getUri() {
        return session.getUri();
    }

    @Override
    public Map<String, String> getHeaders() {
        return session.getHeaders();
    }

    @Override
    public Map<String, String> getParameters() {
        return session.getParms();
    }

    @Override
    public InputStream getInputStream() {
        return session.getInputStream();
    }

    @Override
    public Response makeResponse(ResponseStatusCode statusCode, String mimeType, String body) {
        return new ResponseImpl(statusCode, mimeType, body);
    }
}
