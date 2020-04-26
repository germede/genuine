package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.template.DesktopTemplate;
import org.fluentness.controller.desktop.style.DesktopStyle;

public abstract class AbstractDesktopView<C extends AbstractDesktopController> {

    private C controller;

    final void setController(C controller) {
        this.controller = controller;
    }

    protected final C controller() {
        return controller;
    }

    public abstract DesktopStyle getStyle();

    public abstract DesktopTemplate getTemplate();
}
