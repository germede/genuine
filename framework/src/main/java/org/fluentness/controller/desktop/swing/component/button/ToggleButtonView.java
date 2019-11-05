package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ToggleButtonView implements AbstractButtonView<ToggleButtonView, JButton> {

    JButton jButton = new JButton();

    @Override
    public JButton getView() {
        return jButton;
    }

    public ToggleButtonView action(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
        return this;
    }

}
