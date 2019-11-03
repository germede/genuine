package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.DesktopView;

import java.awt.*;

public interface SwingComponent extends DesktopView {
    Component getComponent();

    @Override
    default void render() {
        getComponent().setVisible(true);
    }

}
