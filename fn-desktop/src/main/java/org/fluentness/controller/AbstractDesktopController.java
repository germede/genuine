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

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected  @interface Action {

    }
}
