package org.fluentness.controller.desktop.swing.button;

import org.fluentness.controller.desktop.swing.JComponentBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;

public class JButtonBuilder implements AbstractButtonBuilder<JButtonBuilder, JButton> {

    JButton jButton = new JButton();

    @Override
    public JButton getJComponent() {
        return jButton;
    }

    public JButtonBuilder action(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
        return this;
    }

}
