package org.fluentness.service.dispatcher;

import org.fluentness.controller.web.WebAction;

import static org.fluentness.controller.web.AbstractWebController.getPath;

public final class ResponseFactory {

    public static Response redirect(WebAction webAction) {
        return response -> {
            response.setStatus(301);
            response.setHeader("Location", getPath(webAction));
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
