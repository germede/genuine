package org.fluentness.controller;

import org.fluentness.service.memory.DefaultMemory;
import org.fluentness.view.AbstractGameView;

import java.lang.annotation.*;

public abstract class AbstractGameController<V extends AbstractGameView> extends AbstractViewController<V> {

    public AbstractGameController(V view) {
        super(view, Action.class);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String selector();

    }

    public void run() {

    }

    protected void loop() {

    }

}
