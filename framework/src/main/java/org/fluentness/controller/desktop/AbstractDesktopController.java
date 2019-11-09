package org.fluentness.controller.desktop;

import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.swing.SwingViewRegistry;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractDesktopController implements Controller {

    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    protected <View extends Container> View getViewByName(Class<View> viewClass, String name) {
        return SwingViewRegistry.getByName(viewClass, name);
    }

    public abstract DesktopView getMainView();
}
