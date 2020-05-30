package org.fluentness.prototype.controller;

import org.fluentness.controller.view.AbstractWebViewController;
import org.fluentness.prototype.view.NotesView;

public class NotesController extends AbstractWebViewController<NotesView> {

    public NotesController(NotesView view) {
        super(view, "/notes");
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