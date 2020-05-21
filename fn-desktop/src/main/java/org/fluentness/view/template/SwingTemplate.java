package org.fluentness.view.template;

import org.fluentness.view.container.Container;

import javax.swing.*;

public class SwingTemplate extends JFrame implements Template {

    public SwingTemplate(String title, Container container) {
        super(title);
        setContentPane((java.awt.Container) container);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void render() {
        setVisible(true);
    }

}
