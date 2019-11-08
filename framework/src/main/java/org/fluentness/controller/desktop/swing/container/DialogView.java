package org.fluentness.controller.desktop.swing.container;

import org.fluentness.controller.desktop.swing.AbstractSwingView;
import org.fluentness.controller.desktop.swing.component.MenuBarView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DialogView extends AbstractWindowView<DialogView, JDialog> {

    JDialog jDialog = new JDialog();

    public DialogView(AbstractSwingView contentPane) {
        jDialog.setContentPane(contentPane.getSwingView());
        jDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jDialog.pack();
    }

    @Override
    public JDialog getSwingView() {
        return jDialog;
    }

    // ==== from java.awt.Dialog
    public DialogView modal(boolean modal) {
        jDialog.setModal(modal);
        return this;
    }

    public DialogView resizable(boolean resizable) {
        jDialog.setResizable(resizable);
        return this;
    }

    public DialogView title(String title) {
        jDialog.setTitle(title);
        return this;
    }

    public DialogView undecorated(boolean undecorated) {
        jDialog.setUndecorated(undecorated);
        return this;
    }


    // ==== from javax.swing.JFrame
    public DialogView defaultCloseOperation(int operation) {
        jDialog.setDefaultCloseOperation(operation);
        return this;
    }

    public DialogView glassPane(Component glassPane) {
        jDialog.setGlassPane(glassPane);
        return this;
    }

    public DialogView menuBar(MenuBarView menuBar) {
        jDialog.setJMenuBar(menuBar.getSwingView());
        return this;
    }

    public DialogView layeredPane(JLayeredPane layeredPane) {
        jDialog.setLayeredPane(layeredPane);
        return this;
    }

    public DialogView transferHandler(TransferHandler newHandler) {
        jDialog.setTransferHandler(newHandler);
        return this;
    }
}
