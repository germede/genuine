package org.fluentness.view.desktop.component;

import javax.swing.*;

public class PanelView extends AbstractComponentView<PanelView, JPanel> {

    public PanelView(AbstractComponentView... JComponentBuilders) {
        super(new JPanel());
        for (AbstractComponentView component : JComponentBuilders) {
            view.add(component.getView());
        }
    }

}
