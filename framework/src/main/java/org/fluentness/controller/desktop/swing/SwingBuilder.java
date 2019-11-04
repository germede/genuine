package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.DesktopView;

import java.awt.*;

public interface SwingBuilder<View extends Container> extends DesktopView {
    View getView();
}
