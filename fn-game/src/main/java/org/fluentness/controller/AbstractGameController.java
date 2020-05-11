package org.fluentness.controller;

import java.lang.annotation.*;

public abstract class AbstractGameController<V extends AbstractGame> implements Controller {

    protected final V view;

    public AbstractGameController(V view) {
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

        String selector();
        // for onclick or keyboard events.
    }

    public abstract void loop();

}
