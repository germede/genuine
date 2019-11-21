package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.style.DesktopStyle;

public abstract class AbstractDesktopController implements Controller {

    public abstract DesktopStyle getGlobalStyle();

    public abstract DesktopView getMainView();

}
