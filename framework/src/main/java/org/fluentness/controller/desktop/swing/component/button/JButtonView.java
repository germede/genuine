package org.fluentness.controller.desktop.swing.component.button;

import javax.swing.*;
import java.awt.event.ActionListener;

public class JButtonView implements AbstractButtonView<JButtonView, JButton> {

    JButton jButton = new JButton();

    @Override
    public JButton getView() {
        return jButton;
    }

    public JButtonView action(ActionListener actionListener) {
        jButton.addActionListener(actionListener);
        return this;
    }

}
