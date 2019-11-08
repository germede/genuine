package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameView extends AbstractWindowView<FrameView, JFrame> {

    JFrame jFrame = new JFrame();

    public FrameView(AbstractSwingView contentPane) {
        jFrame.setContentPane(contentPane.getSwingView());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.pack();
    }

    @Override
    public JFrame getSwingView() {
        return jFrame;
    }

    // ==== from java.awt.Frame
    public FrameView extendedState(int state) {
        jFrame.setExtendedState(state);
        return this;
    }

    public FrameView maximizedBounds(Rectangle bounds) {
        jFrame.setMaximizedBounds(bounds);
        return this;
    }

    public FrameView resizable(boolean resizable) {
        jFrame.setResizable(resizable);
        return this;
    }

    public FrameView state(int state) {
        jFrame.setState(state);
        return this;
    }

    public FrameView title(String title) {
        jFrame.setTitle(title);
        return this;
    }

    public FrameView undecorated(boolean undecorated) {
        jFrame.setUndecorated(undecorated);
        return this;
    }


    // ==== from javax.swing.JFrame
    public FrameView defaultCloseOperation(int operation) {
        jFrame.setDefaultCloseOperation(operation);
        return this;
    }

    public FrameView glassPane(Component glassPane) {
        jFrame.setGlassPane(glassPane);
        return this;
    }

    public FrameView menuBar(MenuBarView menuBar) {
        jFrame.setJMenuBar(menuBar.getSwingView());
        return this;
    }

    public FrameView layeredPane(JLayeredPane layeredPane) {
        jFrame.setLayeredPane(layeredPane);
        return this;
    }

    public FrameView transferHandler(TransferHandler newHandler) {
        jFrame.setTransferHandler(newHandler);
        return this;
    }
}
