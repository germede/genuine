package org.fluentness.flow.component.controller;

import org.fluentness.base.service.server.FluentnessServlet;
import org.fluentness.flow.component.view.View;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.fluentness.base.common.constant.HttpMethods.*;
import static org.fluentness.base.common.constant.HttpStatusCodes.OK;

public interface ControllerFactory {

    default Controller actions(String baseRoute, Action... actions) {
        return new Controller(baseRoute, actions);
    }

    default Controller actions(Action... actions) {
        return new Controller(actions);
    }

    default Action get(String route, ActionHandler action) {
        return new Action(GET, route, action);
    }

    default Action head(String route, ActionHandler action) {
        return new Action(HEAD, route, action);
    }

    default Action post(String route, ActionHandler action) {
        return new Action(POST, route, action);
    }

    default Action put(String route, ActionHandler action) {
        return new Action(PUT, route, action);
    }

    default Action delete(String route, ActionHandler action) {
        return new Action(DELETE, route, action);
    }

    default Action connect(String route, ActionHandler action) {
        return new Action(CONNECT, route, action);
    }

    default Action options(String route, ActionHandler action) {
        return new Action(OPTIONS, route, action);
    }

    default Action trace(String route, ActionHandler action) {
        return new Action(TRACE, route, action);
    }

    default HttpServletResponse render(View view) throws IOException {
        return response(view.renderWithCache());
    }

    default HttpServletResponse response(String body) throws IOException {
        HttpServletResponse response = FluentnessServlet.response;
        response.setStatus(OK);
        PrintWriter writer = response.getWriter();
        writer.print(body);
        return response;
    }

    default HttpServletResponse redirect(String to) throws IOException {
        HttpServletResponse response = FluentnessServlet.response;
        response.sendRedirect(to);
        return response;
    }
}
