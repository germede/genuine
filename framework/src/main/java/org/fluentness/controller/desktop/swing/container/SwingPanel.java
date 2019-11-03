package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.component.SwingComponent;

import javax.swing.*;
import java.awt.*;

public class SwingPanel implements SwingContainer {

    private JPanel panel = new JPanel();

    public SwingPanel(SwingComponent... swingComponents) {
        panel.setLayout(new BorderLayout());
        for (SwingComponent component : swingComponents) {
            panel.add(component.getComponent());
        }
    }

    @Override
    public Container getContainer() {
        return panel;
    }

    public SwingPanel layout(LayoutManager layout) {
//        panel.setLayout(layout);
        return this;
    }

}
