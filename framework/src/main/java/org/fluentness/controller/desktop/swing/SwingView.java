package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.DesktopView;

import java.awt.*;

public interface SwingView<View extends Container> extends DesktopView {
    View getView();
}
