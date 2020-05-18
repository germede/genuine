package org.fluentness.controller.swing;

import org.fluentness.controller.DesktopTemplate;

import java.awt.*;

public class SwingTemplate implements DesktopTemplate {

    private final Window window;

    public SwingTemplate(Window window) {
        this.window = window;
        this.window.setVisible(true);
    }

    public Window getWindow() {
        return window;
    }

}
