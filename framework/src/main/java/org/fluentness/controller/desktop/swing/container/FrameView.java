package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.SwingView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameView implements SwingView<JFrame> {

    JFrame jFrame = new JFrame();

    public FrameView(SwingView swingView) {
        jFrame.setContentPane(swingView.getView());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.pack();
    }

    @Override
    public JFrame getView() {
        return jFrame;
    }

    public FrameView title(String title) {
        jFrame.setTitle(title);
        return this;
    }

    public FrameView bounds(int x, int y, int width, int height) {
        jFrame.setBounds(x, y, width, height);
        return this;
    }

    public FrameView center() {
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
//        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
//        frame.setLocation(x, y);
        jFrame.setLocationRelativeTo(null);
        return this;
    }

    public FrameView minimumSize(int x, int y) {
        jFrame.setMinimumSize(new Dimension(x,y));
        return this;
    }

    public FrameView preferredSize(int x, int y) {
        jFrame.setPreferredSize(new Dimension(x,y));
        return this;
    }


    @Override
    public void render() {
        jFrame.setVisible(true);
    }
}
