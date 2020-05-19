package org.fluentness.service.server;

public interface Response {

    void addHeader(String key, String value);

    int getStatusCode();
}
