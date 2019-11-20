package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.swing.SwingViewRegistry;

import java.awt.*;

public abstract class AbstractDesktopController<Desktop extends DesktopViewHolder> implements Controller {

    public abstract Desktop getDesktop();

    protected <SwingView extends Container> SwingView getSwingViewByName(Class<SwingView> viewClass, String name) {
        return SwingViewRegistry.getByName(viewClass, name);
    }

}
