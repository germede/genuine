package org.fluentness.controller;

import org.fluentness.view.View;

public abstract class ViewController<V extends View> implements Controller {

    protected final V view;

    public ViewController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }
}
