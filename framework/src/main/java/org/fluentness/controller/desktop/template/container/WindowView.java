package org.fluentness.controller.desktop.template.container;

import org.fluentness.controller.desktop.template.DesktopTemplate;

import javax.swing.*;
import java.awt.*;

public class WindowView extends AbstractWindowView<WindowView, JWindow> {

    public WindowView(DesktopTemplate contentPane) {
        super(new JWindow());
        view.setContentPane(contentPane.getView());
        view.pack();
    }

    public WindowView glassPane(Component glassPane) {
        view.setGlassPane(glassPane);
        return this;
    }

    public WindowView layeredPane(JLayeredPane layeredPane) {
        view.setLayeredPane(layeredPane);
        return this;
    }

    public WindowView transferHandler(TransferHandler newHandler) {
        view.setTransferHandler(newHandler);
        return this;
    }
}
