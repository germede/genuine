package org.fluentness.flow.component.controller;

import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.base.service.server.HttpResponse;
import org.fluentness.flow.component.view.View;

import static org.fluentness.base.common.constant.HttpMethods.*;
import static org.fluentness.base.common.constant.HttpStatusCodes.*;

public interface ControllerFactory {

    default Controller actions(String baseRoute, KeyValuePair<Action>... actions) {
        return new Controller(baseRoute, actions);
    }

    default Controller actions(KeyValuePair<Action>... actions) {
        return new Controller(actions);
    }

    default Action get(String route, ActionExecutor action) {
        return new Action(GET, route, action);
    }

    default Action head(String route, ActionExecutor action) {
        return new Action(HEAD, route, action);
    }

    default Action post(String route, ActionExecutor action) {
        return new Action(POST, route, action);
    }

    default Action put(String route, ActionExecutor action) {
        return new Action(PUT, route, action);
    }

    default Action delete(String route, ActionExecutor action) {
        return new Action(DELETE, route, action);
    }

    default Action connect(String route, ActionExecutor action) {
        return new Action(CONNECT, route, action);
    }

    default Action options(String route, ActionExecutor action) {
        return new Action(OPTIONS, route, action);
    }

    default Action trace(String route, ActionExecutor action) {
        return new Action(TRACE, route, action);
    }

    default HttpResponse render(View view) {
        return new HttpResponse(OK).withBody(view.renderWithCache());
    }

    default HttpResponse response(String body) {
        return new HttpResponse(OK).withBody(body);
    }

    default HttpResponse redirect(String to) {
        return new HttpResponse(MOVED_PERMANENTLY).withHeader("Location", to);
    }
}
