package org.fluentness.controller;

import org.fluentness.base.constants.HttpMethods;
import org.fluentness.base.constants.HttpStatusCodes;
import org.fluentness.base.onion.Producer;
import org.fluentness.base.lambdas.KeyValuePair;
import org.fluentness.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class ControllerProducer implements Producer<Controller>, HttpMethods, HttpStatusCodes {

    @Override
    public Class<Controller> getProducedComponentType() {
        return Controller.class;
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

    protected Response render(View view) {
        return new Response(OK).setBody(view.toString());
    }

    protected Response response(String body) {
        return new Response(OK).setBody(body);
    }

    protected Response redirect(String to) {
        return new Response(MOVED_PERMANENTLY).setHeader("Location", to);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Route {
        String value();
    }
}
