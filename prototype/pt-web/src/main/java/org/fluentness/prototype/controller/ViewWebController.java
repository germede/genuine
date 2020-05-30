package org.fluentness.prototype.controller;

import org.fluentness.controller.event.AbstractViewWebController;
import org.fluentness.prototype.view.WebView;

public class ViewWebController extends AbstractViewWebController<WebView> {

    public ViewWebController(WebView view) {
        super(view, "/");
        onClick(view.button1, this::doNothing);
        onClick(view.button2, this::doSomething);
    }

    private void doSomething() {
        System.out.println("TEST");
    }

    private void doNothing() {
        view.button1.setText("HA!");
        view.root.appendChild(view.button1);
    }

}