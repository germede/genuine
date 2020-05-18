package org.fluentness.controller;

public abstract class AbstractDesktopController<D extends AbstractDesktop> implements Controller {

    private final D desktop;

    public AbstractDesktopController(D desktop) {
        this.desktop = desktop;
    }

    public final D getDesktop() {
        return desktop;
    }

}
