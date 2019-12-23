package org.fluentness.view.desktop.container;

import org.fluentness.view.desktop.AbstractSwingView;
import org.fluentness.view.desktop.component.MenuBarView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameView extends AbstractWindowView<FrameView, JFrame> {

    public FrameView(AbstractSwingView contentPane) {
        super(new JFrame());
        view.setContentPane(contentPane.getView());
        view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        view.pack();
    }

    // ==== from java.awt.Frame
    public FrameView extendedState(int state) {
        view.setExtendedState(state);
        return this;
    }

    public FrameView maximizedBounds(Rectangle bounds) {
        view.setMaximizedBounds(bounds);
        return this;
    }

    public FrameView resizable(boolean resizable) {
        view.setResizable(resizable);
        return this;
    }

    public FrameView state(int state) {
        view.setState(state);
        return this;
    }

    public FrameView title(String title) {
        view.setTitle(title);
        return this;
    }

    public FrameView undecorated(boolean undecorated) {
        view.setUndecorated(undecorated);
        return this;
    }


    // ==== from javax.swing.JFrame
    public FrameView defaultCloseOperation(int operation) {
        view.setDefaultCloseOperation(operation);
        return this;
    }

    public FrameView glassPane(Component glassPane) {
        view.setGlassPane(glassPane);
        return this;
    }

    public FrameView menuBar(MenuBarView menuBar) {
        view.setJMenuBar(menuBar.getView());
        return this;
    }

    public FrameView layeredPane(JLayeredPane layeredPane) {
        view.setLayeredPane(layeredPane);
        return this;
    }

    public FrameView transferHandler(TransferHandler newHandler) {
        view.setTransferHandler(newHandler);
        return this;
    }
}
