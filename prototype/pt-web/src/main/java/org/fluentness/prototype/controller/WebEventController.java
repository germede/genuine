package org.fluentness.prototype.controller;

import org.fluentness.controller.event.AbstractEventWebController;
import org.fluentness.prototype.view.WebView;

public class WebEventController extends AbstractEventWebController<WebView> {

    public WebEventController(WebView view) {
        super(view, "/");
        onClick(view.button1, this::doNothing);
    }

    private void doNothing() {
        System.out.println("test");
    }

}