package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DialogView extends AbstractWindowView<DialogView, JDialog> {
    
    public DialogView(AbstractSwingView contentPane) {
        super(new JDialog());
        view.setContentPane(contentPane.getView());
        view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        view.pack();
    }

    // ==== from java.awt.Dialog
    public DialogView modal(boolean modal) {
        view.setModal(modal);
        return this;
    }

    public DialogView resizable(boolean resizable) {
        view.setResizable(resizable);
        return this;
    }

    public DialogView title(String title) {
        view.setTitle(title);
        return this;
    }

    public DialogView undecorated(boolean undecorated) {
        view.setUndecorated(undecorated);
        return this;
    }


    // ==== from javax.swing.JFrame
    public DialogView defaultCloseOperation(int operation) {
        view.setDefaultCloseOperation(operation);
        return this;
    }

    public DialogView glassPane(Component glassPane) {
        view.setGlassPane(glassPane);
        return this;
    }

    public DialogView menuBar(MenuBarView menuBar) {
        view.setJMenuBar(menuBar.getView());
        return this;
    }

    public DialogView layeredPane(JLayeredPane layeredPane) {
        view.setLayeredPane(layeredPane);
        return this;
    }

    public DialogView transferHandler(TransferHandler newHandler) {
        view.setTransferHandler(newHandler);
        return this;
    }
}
