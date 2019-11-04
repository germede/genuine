package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JButtonBuilder implements AbstractButtonBuilder<JButtonBuilder, JButton> {

    JButton jButton = new JButton();

    @Override
    public JButton getView() {
        return jButton;
    }

    public JButtonBuilder action(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
        return this;
    }

}
