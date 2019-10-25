package org.fluentness.controller.web;

import org.fluentness.service.server.HttpStatusCode;
import org.fluentness.service.server.HttpServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class HttpServletResponseFactory {

    private HttpServletResponseFactory() {

    }

    public static HttpServletResponse response(HttpStatusCode httpStatusCode, String body) throws IOException {
        HttpServletResponse response = HttpServlet.response;
        response.setStatus(httpStatusCode.toInt());
        PrintWriter writer = response.getWriter();
        writer.print(body);
        return response;
    }

    public static HttpServletResponse render(WebView view) throws IOException {
        return response(HttpStatusCode.OK, view.renderWithCache());
    }
}
