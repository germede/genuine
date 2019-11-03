package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopView;
import org.fluentness.controller.desktop.DesktopViewFactory;
import org.fluentness.controller.desktop.swing.component.SwingButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesktopController extends AbstractDesktopController {

    @Override
    public DesktopView getDesktopView() {
        return new Desktop(this).main();
    }

    @Action(id = "test_button", listener = ActionListener.class)
    public void showInfoMessage(ActionEvent event) {
        SwingButton test_button = DesktopViewFactory.getView(SwingButton.class, "test_button");
        JOptionPane.showMessageDialog(null, "asdf");
    }
}
