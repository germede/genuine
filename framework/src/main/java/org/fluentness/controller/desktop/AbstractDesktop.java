package org.fluentness.controller.desktop;

import org.fluentness.view.desktop.style.DesktopStyle;

public abstract class AbstractDesktop<C extends AbstractDesktopController> {

    protected final C controller;

    public AbstractDesktop(C controller) {
        this.controller = controller;
    }

    public abstract DesktopStyle getStyle();

    public abstract DesktopView getView();
}
