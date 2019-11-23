package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;

public abstract class AbstractDesktopController<D extends AbstractDesktop> implements Controller {

    protected final D desktop;

    protected AbstractDesktopController(D desktop) {
        this.desktop = desktop;
        desktop.setController(this);
    }

    public final D getDesktop() {
        return desktop;
    }
}
