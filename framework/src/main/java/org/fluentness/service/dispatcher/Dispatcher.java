package org.fluentness.service.dispatcher;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Singleton
public interface Dispatcher extends Servlet, Service {

    @Override
    void service(ServletRequest httpServletRequest, ServletResponse response) throws ServletException, IOException;

}
