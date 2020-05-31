package org.fluentness.prototype.controller;

import org.fluentness.controller.view.AbstractWebViewController;
import org.fluentness.prototype.view.IndexView;

public class IndexController extends AbstractWebViewController<IndexView> {

    public IndexController(IndexView view) {
        super(view, "/");
        onClick(view.button1, this::doNothing);
    }

    private void doNothing() {
        view.button1.setText("HA!");
    }

}