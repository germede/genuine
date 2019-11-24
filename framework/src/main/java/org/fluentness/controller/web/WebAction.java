package org.fluentness.controller.web;

public class WebAction {

    private final WebActionReference webActionReference;
    private final AbstractWebController abstractWebController;

    public WebAction(
        WebActionReference webActionReference,
        AbstractWebController abstractWebController
    ) {
        this.webActionReference = webActionReference;
        this.abstractWebController = abstractWebController;
    }

    public WebActionReference getLambda() {
        return webActionReference;
    }

    public AbstractWebController getController() {
        return abstractWebController;
    }
}
