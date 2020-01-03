package org.fluentness.controller.desktop.template.swing;

import org.fluentness.controller.desktop.template.DesktopTemplate;

import java.awt.*;

public class SwingTemplate<V extends Window>  implements DesktopTemplate {

    private V actualSwing;

    SwingTemplate(V actualSwing, Swing content) {
        this.actualSwing = actualSwing;
    }

    public V getActualSwing() {
        return actualSwing;
    }

    @Override
    public void render() {
        actualSwing.setVisible(true);
    }

}
