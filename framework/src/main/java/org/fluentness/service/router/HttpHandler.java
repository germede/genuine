package org.fluentness.service.router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@FunctionalInterface
public interface HttpHandler {
    void handle(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException;
}
