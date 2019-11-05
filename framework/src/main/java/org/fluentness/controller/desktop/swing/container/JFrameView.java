package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.SwingView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JFrameView implements SwingView<JFrame> {

    JFrame jFrame = new JFrame();

    public JFrameView(SwingView swingView) {
        jFrame.setContentPane(swingView.getView());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.pack();
    }

    @Override
    public JFrame getView() {
        return jFrame;
    }

    public JFrameView title(String title) {
        jFrame.setTitle(title);
        return this;
    }

    public JFrameView bounds(int x, int y, int width, int height) {
        jFrame.setBounds(x, y, width, height);
        return this;
    }

    public JFrameView center() {
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
//        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
//        frame.setLocation(x, y);
        jFrame.setLocationRelativeTo(null);
        return this;
    }

    public JFrameView minimumSize(int x, int y) {
        jFrame.setMinimumSize(new Dimension(x,y));
        return this;
    }

    public JFrameView preferredSize(int x, int y) {
        jFrame.setPreferredSize(new Dimension(x,y));
        return this;
    }


    @Override
    public void render() {
        jFrame.setVisible(true);
    }
}
