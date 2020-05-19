package org.fluentness.service.server;

import fi.iki.elonen.NanoHTTPD;

import java.io.ByteArrayInputStream;

public class ResponseImpl extends NanoHTTPD.Response implements Response {

    ResponseImpl(ResponseStatusCode statusCode, String mimeType, String body) {
        super(statusCode, mimeType, new ByteArrayInputStream(body.getBytes()), body.getBytes().length);
    }

    @Override
    public int getStatusCode() {
        return getStatus().getRequestStatus();
    }
}
