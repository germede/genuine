package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.swing.SwingViewRegistry;

import java.awt.*;

public abstract class AbstractDesktopController<V extends DesktopViewHolder> implements Controller {

    protected V desktop;

    protected AbstractDesktopController() {
        desktop = initViewHolder();
    }

    protected abstract V initViewHolder();

    protected <SwingView extends Container> SwingView getSwingViewByName(Class<SwingView> viewClass, String name) {
        return SwingViewRegistry.getByName(viewClass, name);
    }

}
