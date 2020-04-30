package org.fluentness.service.server;

import java.util.List;
import java.util.Map;

public interface Response {

    Map<String, List<String>> getHeaders();

    Response addHeader(ResponseHeader key, String value);

    int getCode();

    String getBody();

    Response setBody(String body);
}
