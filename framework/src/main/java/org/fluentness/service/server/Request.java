package org.fluentness.service.server;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface Request {

    Map<String, List<String>> getHeaders();

    String getMethod();

    URI getUri();

    InputStream getBody();

    Locale getLocale();

    Response makeResponse(int code);
}
