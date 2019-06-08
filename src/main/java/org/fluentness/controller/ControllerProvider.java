package org.fluentness.controller;

import org.fluentness.common.lambdas.NamedValue;
import org.fluentness.common.Provider;
import org.fluentness.common.constants.HttpMethods;
import org.fluentness.common.constants.HttpStatusCodes;
import org.fluentness.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ControllerProvider extends Provider<Controller>, HttpMethods, HttpStatusCodes {

    default Controller actions(NamedValue<Action>... actions) {
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

    default Response render(View view, NamedValue<Object>... attributes) {
        // instantiate view and set its attributes
//        Arrays.stream(attributes)
//            .forEach(attribute -> view.injectAttribute(attribute.name(), attribute.value()));
        return new Response(OK).setBody(view.render());
    }

    default Response response(String body) {
        return new Response(OK).setBody(body);
    }

    default Response redirect(String to) {
        return new Response(MOVED_PERMANENTLY).setHeader("Location", to);
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Route {
        String value();
    }
}
