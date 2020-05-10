package org.fluentness.controller;

import org.fluentness.view.View;

import java.lang.annotation.Annotation;

public abstract class AbstractViewController<V extends View> implements Controller {

    protected final V view;
    private final Class<? extends Annotation> actionClass;

    public AbstractViewController(V view, Class<? extends Annotation> actionClass) {
        this.view = view;
        this.actionClass = actionClass;
    }

    public final V getView() {
        return view;
    }

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return actionClass;
    }
}
