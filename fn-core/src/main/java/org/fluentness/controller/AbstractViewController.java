package org.fluentness.controller;

import org.fluentness.view.View;

public abstract class AbstractViewController<V extends View> implements Controller {

    protected final V view;

    public AbstractViewController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }
}
