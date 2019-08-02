package org.fluentness.flow.component.controller;

import static org.fluentness.base.common.constant.HttpMethod.*;

public final class ControllerFactory {

    private ControllerFactory() {

    }

    public static Controller actions(String baseRoute, Action... actions) {
        return new Controller(baseRoute, actions);
    }

    public static Controller actions(Action... actions) {
        return new Controller(actions);
    }

    public static Action get(String route, Controlleri action) {
        return new Action(GET, route, action);
    }

    public static Action head(String route, Controlleri action) {
        return new Action(HEAD, route, action);
    }

    public static Action post(String route, Controlleri action) {
        return new Action(POST, route, action);
    }

    public static Action put(String route, Controlleri action) {
        return new Action(PUT, route, action);
    }

    public static Action delete(String route, Controlleri action) {
        return new Action(DELETE, route, action);
    }

    public static Action connect(String route, Controlleri action) {
        return new Action(CONNECT, route, action);
    }

    public static Action options(String route, Controlleri action) {
        return new Action(OPTIONS, route, action);
    }

    public static Action trace(String route, Controlleri action) {
        return new Action(TRACE, route, action);
    }

}
