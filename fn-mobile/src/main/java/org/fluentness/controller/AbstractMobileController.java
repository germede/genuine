package org.fluentness.controller;

import org.fluentness.view.AbstractMobileView;

import java.lang.annotation.*;

public abstract class AbstractMobileController<V extends AbstractMobileView> extends AbstractViewController<V> {

    public AbstractMobileController(V view) {
        super(view, Action.class);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String selector();
    }


}
