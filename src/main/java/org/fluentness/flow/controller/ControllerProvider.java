package org.fluentness.flow.controller;

import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.constants.HttpStatusCodes;
import org.fluentness.base.generics.Provider;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.base.networking.HttpResponse;
import org.fluentness.flow.view.View;

public abstract class ControllerProvider implements Provider<Controller>, HttpMethods, HttpStatusCodes {

    @Override
    public Class<Controller> getProducedComponentType() {
        return Controller.class;
    }

    protected Controller actions(String baseRoute, KeyValuePair<Action>... actions) {
        return new Controller(baseRoute, actions);
    }

    protected Controller actions(KeyValuePair<Action>... actions) {
        return new Controller(actions);
    }

    protected Action get(String route, ActionExecutor action) {
        return new Action(GET, route, action);
    }

    protected Action head(String route, ActionExecutor action) {
        return new Action(HEAD, route, action);
    }

    protected Action post(String route, ActionExecutor action) {
        return new Action(POST, route, action);
    }

    protected Action put(String route, ActionExecutor action) {
        return new Action(PUT, route, action);
    }

    protected Action delete(String route, ActionExecutor action) {
        return new Action(DELETE, route, action);
    }

    protected Action connect(String route, ActionExecutor action) {
        return new Action(CONNECT, route, action);
    }

    protected Action options(String route, ActionExecutor action) {
        return new Action(OPTIONS, route, action);
    }

    protected Action trace(String route, ActionExecutor action) {
        return new Action(TRACE, route, action);
    }

    protected HttpResponse render(View view) {
        return new HttpResponse(OK).setBody(view.renderWithCache());
    }

    protected HttpResponse response(String body) {
        return new HttpResponse(OK).setBody(body);
    }

    protected HttpResponse redirect(String to) {
        return new HttpResponse(MOVED_PERMANENTLY).setHeader("Location", to);
    }

}
