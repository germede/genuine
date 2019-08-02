package org.fluentness.flow.component.controller;

import org.fluentness.base.common.constant.HttpStatusCode;
import org.fluentness.base.service.server.HttpServlet;
import org.fluentness.flow.component.view.View;

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

    public static HttpServletResponse render(View view) throws IOException {
        return response(HttpStatusCode.OK, view.renderWithCache());
    }
}
