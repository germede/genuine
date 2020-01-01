package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.view.style.DesktopStyle;

public interface View<C extends Controller> {

    DesktopStyle getStyle();

    DesktopView getView();
}
