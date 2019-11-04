package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.SwingBuilder;

import javax.swing.*;
import java.awt.*;

public class JPanelBuilder implements JComponentBuilder<JPanelBuilder, JPanel> {

    private JPanel jPanel = new JPanel();

    public JPanelBuilder(JComponentBuilder... JComponentBuilders) {
        for (JComponentBuilder component : JComponentBuilders) {
            jPanel.add(component.getView());
        }
    }

    @Override
    public JPanel getView() {
        return jPanel;
    }

    public JPanelBuilder layout(LayoutManager layout) {
        jPanel.setLayout(layout);
        return this;
    }

    public JPanelBuilder arrangements(String... arrangements) {

        return this;
    }

    public SwingBuilder borderLayout(String... arrangements) {
        jPanel.setLayout(new BorderLayout());
        for (int i = 0; i < jPanel.getComponentCount() && i < arrangements.length; i++) {
            Component component = jPanel.getComponent(i);
            jPanel.remove(component);
            jPanel.add(component,arrangements[i]);
        }
        return this;
    }
}
