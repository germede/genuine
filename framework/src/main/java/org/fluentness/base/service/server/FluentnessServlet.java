package org.fluentness.base.service.server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FluentnessServlet extends HttpServlet {


    public static HttpServletResponse response;
    private Map<String, HttpHandler> routing;

    public FluentnessServlet(Map<String, HttpHandler> routing) {
        this.routing = routing;
    }

    public FluentnessServlet() {
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
