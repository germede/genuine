package org.fluentness.service.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class HttpServlet extends javax.servlet.http.HttpServlet {


    public static HttpServletResponse response;
    private Map<String, HttpHandler> routing;

    HttpServlet(Map<String, HttpHandler> routing) {
        this.routing = routing;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        response = resp;
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("asdf");
    }
}
