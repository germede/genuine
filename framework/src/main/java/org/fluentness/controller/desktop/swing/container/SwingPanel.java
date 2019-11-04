package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.JComponentBuilder;

import javax.swing.*;
import java.awt.*;

public class SwingPanel implements SwingContainer {

    private JPanel panel = new JPanel();

    public SwingPanel(JComponentBuilder... JComponentBuilders) {
        for (JComponentBuilder component : JComponentBuilders) {
            panel.add(component.getJComponent());
        }
    }

    @Override
    public Container getContainer() {
        return panel;
    }

    public SwingPanel layout(LayoutManager layout) {
        panel.setLayout(layout);
        return this;
    }

}
