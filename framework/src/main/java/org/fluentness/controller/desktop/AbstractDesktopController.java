package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.swing.SwingViewRegistry;

import java.awt.*;

public abstract class AbstractDesktopController<Desktop extends DesktopViewHolder> implements Controller {

    protected Desktop desktop;

    protected AbstractDesktopController() {
        desktop = initViewHolder();
    }

    public Desktop getDesktop() {
        return desktop;
    }

    protected abstract Desktop initViewHolder();

    protected <SwingView extends Container> SwingView getSwingViewByName(Class<SwingView> viewClass, String name) {
        return SwingViewRegistry.getByName(viewClass, name);
    }

}
