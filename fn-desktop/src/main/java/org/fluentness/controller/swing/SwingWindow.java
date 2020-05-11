package org.fluentness.controller.swing;

import org.fluentness.controller.RootDesktopView;

import java.awt.*;

public class SwingWindow<V extends Window> extends Swing<V> implements RootDesktopView {

    public SwingWindow(V view, CharSequence... swings) {
        super(view, swings);
    }

    public void render() {
        view.setVisible(true);
    }
}
