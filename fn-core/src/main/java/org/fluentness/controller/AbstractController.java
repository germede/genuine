package org.fluentness.controller;

import org.fluentness.view.View;

public abstract class AbstractController<V extends View> implements Controller {

    private final V view;

    public AbstractController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }

}
