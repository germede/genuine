package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonView implements AbstractButtonView<ButtonView, JButton> {

    JButton jButton = new JButton();

    @Override
    public JButton getView() {
        return jButton;
    }

    public ButtonView action(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
        return this;
    }

}
