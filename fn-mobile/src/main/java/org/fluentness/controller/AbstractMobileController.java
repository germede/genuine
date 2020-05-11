package org.fluentness.controller;

import android.view.View;

import java.lang.annotation.*;

public abstract class AbstractMobileController<V extends AbstractMobile> implements Controller {

    private final V view;

    public AbstractMobileController(V view) {
        this.view = view;
    }

    public final V getView() {
        return view;
    }

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        Class<? extends View> selector();
    }


}
