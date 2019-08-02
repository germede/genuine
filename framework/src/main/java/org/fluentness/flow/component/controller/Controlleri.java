package org.fluentness.flow.component.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FunctionalInterface
public interface Controlleri {
    HttpServletResponse handle(HttpServletRequest request) throws IOException;
}
