package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.template.DesktopTemplate;
import org.fluentness.controller.desktop.style.DesktopStyle;

public interface View {

    DesktopStyle getStyle();

    DesktopTemplate getTemplate();
}
