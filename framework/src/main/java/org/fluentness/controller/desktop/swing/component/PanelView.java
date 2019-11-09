package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;

public class PanelView extends AbstractComponentView<PanelView, JPanel> {

    private final JPanel jPanel = new JPanel();

    public PanelView(AbstractComponentView... JComponentBuilders) {
        for (AbstractComponentView component : JComponentBuilders) {
            jPanel.add(component.getSwingView());
        }
    }

    @Override
    public JPanel getSwingView() {
        return jPanel;
    }

}
