package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.view.SwingViewRegistry;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;

public class Mobile extends AbstractDesktopController<Desktop> {

    void test(CaretEvent caretEvent) {
        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
