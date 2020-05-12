package org.fluentness.controller;

import java.lang.annotation.*;

public abstract class AbstractDesktopController<D extends AbstractDesktop> implements Controller {

    private final D desktop;

    public AbstractDesktopController(D desktop) {
        this.desktop = desktop;
    }

    public final D getDesktop() {
        return desktop;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String selector();

        Event event() default Event.CLICK;

    }

    protected enum Event {
        CLICK;
    }
}
