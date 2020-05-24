package org.fluentness.prototype.controller;

import org.fluentness.controller.event.AbstractWebController;
import org.fluentness.prototype.view.WebView;

public class IndexController extends AbstractWebController<WebView> {

    public IndexController(WebView view) {
        super(view, "/");
        onClick(view.button1, this::doNothing);
    }

    private void doNothing() {
        view.button1.setText("HA!");
        view.root.add(view.button1);
    }

}