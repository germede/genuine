package org.fluentness.controller.desktop.swing.component;

import org.fluentness.controller.desktop.swing.SwingView;

import javax.swing.*;
import java.awt.*;

public class JPanelView implements JComponentView<JPanelView, JPanel> {

    private JPanel jPanel = new JPanel();

    public JPanelView(JComponentView... JComponentBuilders) {
        for (JComponentView component : JComponentBuilders) {
            jPanel.add(component.getView());
        }
    }

    @Override
    public JPanel getView() {
        return jPanel;
    }

    public JPanelView layout(LayoutManager layout) {
        jPanel.setLayout(layout);
        return this;
    }

    public JPanelView arrangements(String... arrangements) {

        return this;
    }

    public SwingView borderLayout(String... arrangements) {
        jPanel.setLayout(new BorderLayout());
        for (int i = 0; i < jPanel.getComponentCount() && i < arrangements.length; i++) {
            Component component = jPanel.getComponent(i);
            jPanel.remove(component);
            jPanel.add(component,arrangements[i]);
        }
        return this;
    }
}
