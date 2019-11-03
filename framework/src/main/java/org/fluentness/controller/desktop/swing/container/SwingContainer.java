package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.DesktopView;

import java.awt.*;

public interface SwingContainer extends DesktopView {
    Container getContainer();

    @Override
    default void render() {
        getContainer().setVisible(true);
    }
}
