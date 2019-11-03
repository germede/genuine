package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class SwingButton implements SwingComponent {

    JButton button = new JButton();

    @Override
    public Component getComponent() {
        return button;
    }

    public SwingButton text(String text) {
        button.setText(text);
        return this;
    }

    public SwingButton border(Border border) {
        button.setBorder(border);
        return this;
    }

    public SwingButton action(ActionListener actionListener) {
        button.addActionListener(actionListener);
        return this;
    }

}
