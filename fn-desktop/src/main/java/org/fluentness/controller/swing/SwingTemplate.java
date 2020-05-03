package org.fluentness.controller.swing;

import org.fluentness.controller.DesktopTemplate;

import java.awt.*;

public class SwingTemplate<V extends Window> extends Swing<V> implements DesktopTemplate {

    SwingTemplate(V view, CharSequence... swings) {
        super(view, swings);
    }

    @Override
    public void render() {
        view.setVisible(true);
    }
}
