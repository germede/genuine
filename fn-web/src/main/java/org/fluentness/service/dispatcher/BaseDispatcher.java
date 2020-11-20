package org.fluentness.service.dispatcher;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.log.Log;

import java.io.IOException;

public abstract class BaseDispatcher extends HttpServlet implements Dispatcher {

    protected final Authenticator authenticator;
    protected final Log log;

    public BaseDispatcher(Authenticator authenticator, Log log) {
        this.authenticator = authenticator;
        this.log = log;
    }

    @Override
    protected final void service(HttpServletRequest request, final HttpServletResponse response) throws IOException {
        try {
            if (authenticator.authorize(request, response)) {
                dispatch(request, response);
            }
        } catch (Throwable cause) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            log.error(cause);
        }
        log.debug("%s %s -> %s", request.getMethod(), request.getRequestURI(), response.getStatus());
    }

    protected abstract void dispatch(HttpServletRequest request, HttpServletResponse response) throws Throwable;
}
