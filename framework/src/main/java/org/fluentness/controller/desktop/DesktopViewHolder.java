package org.fluentness.controller.desktop;

import javax.swing.*;

public interface DesktopViewHolder {

    default void setLookAndFeel() {
        try {
            String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(systemLookAndFeelClassName);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    default void setGlobalStyles(DesktopStyleBuilder style) {

    }

    DesktopView getMainView();

}
