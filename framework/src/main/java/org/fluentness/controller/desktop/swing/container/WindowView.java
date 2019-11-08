package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;

import javax.swing.*;
import java.awt.*;

public class WindowView extends AbstractWindowView<WindowView, JWindow> {

    JWindow jFrame = new JWindow();

    public WindowView(AbstractSwingView contentPane) {
        jFrame.setContentPane(contentPane.getSwingView());
        jFrame.pack();
    }

    @Override
    public JWindow getSwingView() {
        return jFrame;
    }

    public WindowView glassPane(Component glassPane) {
        jFrame.setGlassPane(glassPane);
        return this;
    }

    public WindowView layeredPane(JLayeredPane layeredPane) {
        jFrame.setLayeredPane(layeredPane);
        return this;
    }

    public WindowView transferHandler(TransferHandler newHandler) {
        jFrame.setTransferHandler(newHandler);
        return this;
    }
}
