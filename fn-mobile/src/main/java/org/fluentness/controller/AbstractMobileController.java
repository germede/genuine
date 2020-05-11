package org.fluentness.controller;

import android.view.View;

import java.lang.annotation.*;

public abstract class AbstractMobileController<M extends AbstractMobile> implements Controller {

    private final M mobile;

    public AbstractMobileController(M mobile) {
        this.mobile = mobile;
    }

    public final M getMobile() {
        return mobile;
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
