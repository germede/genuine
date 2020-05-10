package org.fluentness.controller;

import org.fluentness.view.AbstractMobileView;

import java.lang.annotation.*;

public abstract class AbstractMobileController<V extends AbstractMobileView> implements Controller {

    private final V view;

    public AbstractMobileController(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String selector();
    }


}
