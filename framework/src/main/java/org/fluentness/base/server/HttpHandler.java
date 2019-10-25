package org.fluentness.base.server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FunctionalInterface
public interface HttpHandler {
    void handle(HttpServletRequest request, HttpServletResponse response);
}
