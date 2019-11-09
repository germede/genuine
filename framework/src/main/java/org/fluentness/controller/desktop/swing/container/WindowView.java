package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;

import javax.swing.*;
import java.awt.*;

public class WindowView extends AbstractWindowView<WindowView, JWindow> {

    private final JWindow jWindow = new JWindow();

    public WindowView(AbstractSwingView contentPane) {
        jWindow.setContentPane(contentPane.getSwingView());
        jWindow.pack();
    }

    @Override
    public JWindow getSwingView() {
        return jWindow;
    }

    public WindowView glassPane(Component glassPane) {
        jWindow.setGlassPane(glassPane);
        return this;
    }

    public WindowView layeredPane(JLayeredPane layeredPane) {
        jWindow.setLayeredPane(layeredPane);
        return this;
    }

    public WindowView transferHandler(TransferHandler newHandler) {
        jWindow.setTransferHandler(newHandler);
        return this;
    }
}
