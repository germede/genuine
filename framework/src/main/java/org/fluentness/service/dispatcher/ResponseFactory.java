package org.fluentness.service.dispatcher;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebActionReference;

public final class ResponseFactory {

    public static Response redirect(WebActionReference action) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", action.getMethod().getAnnotation(AbstractWebController.Action.class).path());
        };
    }

    public static Response redirect(String url) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", url);
        };
    }

    private ResponseFactory() {

    }
}
