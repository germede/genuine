package org.fluentness.controller.swing;

import org.fluentness.controller.DesktopView;

import java.awt.*;

public class SwingView implements DesktopView {

    private final Window window;

    public SwingView(Window window) {
        this.window = window;
    }

    public Window getWindow() {
        return window;
    }
}
