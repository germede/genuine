package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import java.awt.*;

public class SwingLabel implements SwingComponent{

    JLabel label;

    public SwingLabel(String title) {
        label = new JLabel(title);
        label.setVisible(true);
    }

    @Override
    public Component getComponent() {
        return label;
    }

}
