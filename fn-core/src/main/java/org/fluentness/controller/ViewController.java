package org.fluentness.controller;

import org.fluentness.view.View;
import org.fluentness.view.component.Component;
import org.fluentness.view.event.Handler;

public abstract class ViewController<V extends View> implements Controller {

    protected final V view;

    public ViewController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }

    protected abstract void onClick(Component component, Handler handler);
}
