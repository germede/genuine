package org.fluentness.prototype.controller;

import org.fluentness.controller.WebController;
import org.fluentness.prototype.view.IndexView;

public class IndexController extends WebController<IndexView> {

    public IndexController(IndexView view) {
        super(view, "/");
        onClick(view.openModalButton, this::openDialog);
    }

    private void openDialog() {
        view.modal.toggleClass("show");
    }

}