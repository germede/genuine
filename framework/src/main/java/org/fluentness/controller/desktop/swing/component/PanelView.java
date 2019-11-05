package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.SwingView;

import javax.swing.*;
import java.awt.*;

public class PanelView implements ComponentView<PanelView, JPanel> {

    private JPanel jPanel = new JPanel();

    public PanelView(ComponentView... JComponentBuilders) {
        for (ComponentView component : JComponentBuilders) {
            jPanel.add(component.getView());
        }
    }

    @Override
    public JPanel getView() {
        return jPanel;
    }

    public PanelView layout(LayoutManager layout) {
        jPanel.setLayout(layout);
        return this;
    }

    public PanelView arrangements(String... arrangements) {

        return this;
    }

    public SwingView borderLayout(String... arrangements) {
        jPanel.setLayout(new BorderLayout());
        Component[] components = jPanel.getComponents();
        jPanel.removeAll();
        for (int i = 0; i < components.length && i < arrangements.length; i++) {
            jPanel.add(components[i],arrangements[i]);
        }
        return this;
    }
}
