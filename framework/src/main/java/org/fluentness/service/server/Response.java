package org.fluentness.service.server;

import com.sun.net.httpserver.Headers;

public interface Response {

    Headers getHeaders();

    Response addHeader(String key, String value);

    int getCode();

    String getBody();

    Response setBody(String body);
}
