package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import java.awt.*;

public class PanelView extends AbstractComponentView<PanelView, JPanel> {

    protected JPanel jPanel = new JPanel();

    public PanelView(AbstractComponentView... JComponentBuilders) {
        for (AbstractComponentView component : JComponentBuilders) {
            jPanel.add(component.getView());
        }
    }

    @Override
    public JPanel getView() {
        return jPanel;
    }

    public PanelView arrangements(String... arrangements) {

        return this;
    }

    public PanelView borderLayout(String... arrangements) {
        jPanel.setLayout(new BorderLayout());
        Component[] components = jPanel.getComponents();
        jPanel.removeAll();
        for (int i = 0; i < components.length && i < arrangements.length; i++) {
            jPanel.add(components[i], arrangements[i]);
        }
        return this;
    }

    public PanelView boxLayout(int align) {
        jPanel.setLayout(new BoxLayout(getView(), align));
        Component[] components = jPanel.getComponents();
        jPanel.removeAll();
        for (int i = 0; i < components.length; i++) {
            jPanel.add(components[i], Component.CENTER_ALIGNMENT);
        }
        return this;
    }
}
