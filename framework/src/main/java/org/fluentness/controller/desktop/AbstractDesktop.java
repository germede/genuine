package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.style.DesktopStyle;

public abstract class AbstractDesktop<C extends AbstractDesktopController> {

    protected C controller;

    void setController(C controller) {
        this.controller = controller;
    }

    public abstract DesktopStyle getStyle();

    public abstract DesktopView getView();
}
