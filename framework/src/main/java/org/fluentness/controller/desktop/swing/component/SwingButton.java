package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SwingButton implements SwingComponent{

    JButton button;

    public SwingButton(String title) {
        button = new JButton(title);
        button.setVisible(true);
    }

    @Override
    public Component getComponent() {
        return button;
    }

    public SwingButton border(Border border) {
        button.setBorder(border);
        return this;
    }
}
