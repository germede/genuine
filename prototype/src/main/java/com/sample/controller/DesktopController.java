package com.sample.controller;

import com.bulenkov.darcula.DarculaLaf;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopController extends AbstractDesktopController {

    @Override
    public void setLookAndFeel() {
        // set custom look and feel instead of default system one
        try {
            UIManager.put("swing.boldMetal", Boolean.FALSE);
            UIManager.setLookAndFeel(new DarculaLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DesktopView getDesktopView() {
        return new Desktop(this).main();
    }

    @Action(id = "test_button", listener = ActionListener.class)
    public void showInfoMessage(ActionEvent event) {
        //ButtonView test_button = DesktopViewFactory.getView(ButtonView.class, "test_button");
        JOptionPane.showMessageDialog(null, "asdf");
    }
}
