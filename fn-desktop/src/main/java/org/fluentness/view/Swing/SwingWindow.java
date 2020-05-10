package org.fluentness.view.Swing;

import org.fluentness.view.RootDesktopView;

import java.awt.*;

public class SwingWindow<V extends Window> extends Swing<V> implements RootDesktopView {

    public SwingWindow(V view, CharSequence... swings) {
        super(view, swings);
    }

    public void render() {
        view.setVisible(true);
    }
}
