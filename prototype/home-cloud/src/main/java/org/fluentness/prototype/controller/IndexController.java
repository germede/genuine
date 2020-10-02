package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.prototype.view.IndexView;

public class IndexController extends AbstractWebController<IndexView> {

    public IndexController(IndexView view) {
        super(view, "/");
        onClick(view.button1, this::doNothing);
    }

    private void doNothing() {
        view.button1.setText("HA!");
    }

}