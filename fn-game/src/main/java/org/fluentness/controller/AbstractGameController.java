package org.fluentness.controller;

import java.lang.annotation.*;

public abstract class AbstractGameController<V extends AbstractGame> implements Controller {

    protected final V game;

    public AbstractGameController(V game) {
        this.game = game;
    }

    public final V getGame() {
        return game;
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
