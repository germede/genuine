package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.template.DesktopTemplate;
import org.fluentness.controller.desktop.style.DesktopStyle;

public abstract class AbstractDesktopView {

    public DesktopStyle getStyle() {
        return null;
    }

    public abstract DesktopTemplate getTemplate();
}
