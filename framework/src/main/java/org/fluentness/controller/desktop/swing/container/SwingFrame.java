package org.fluentness.controller.desktop.swing.container;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class SwingFrame implements SwingContainer {

    JFrame frame = new JFrame();

    public SwingFrame(SwingContainer swingContainer) {
        frame.setContentPane(swingContainer.getContainer());
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
    }

    @Override
    public Container getContainer() {
        return frame;
    }

    public SwingFrame title(String title) {
        frame.setTitle(title);
        return this;
    }

    public SwingFrame bounds(int x, int y, int width, int height) {
        frame.setBounds(x, y, width, height);
        return this;
    }

    public SwingFrame center() {
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
//        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
//        frame.setLocation(x, y);
        frame.setLocationRelativeTo(null);
        return this;
    }

    public SwingFrame minimumSize(int x, int y) {
        frame.setMinimumSize(new Dimension(x,y));
        return this;
    }

    public SwingFrame preferredSize(int x, int y) {
        frame.setPreferredSize(new Dimension(x,y));
        return this;
    }


}
