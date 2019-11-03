package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import java.awt.*;

public class SwingLabel implements SwingComponent{

    JLabel label = new JLabel();

    public SwingLabel text(String text) {
        label.setText(text);
        return this;
    }

    @Override
    public Component getComponent() {
        return label;
    }

}
