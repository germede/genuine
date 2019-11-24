package org.fluentness.service.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class Request extends HttpServletRequestWrapper {

    private String pathVariable;

    public Request(HttpServletRequest request) {
        super(request);
        request.getRequestURI();
    }
}
