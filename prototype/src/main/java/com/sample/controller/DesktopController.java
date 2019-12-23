package com.sample.controller;

import com.sample.view.Desktop;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.persistence.Persistence;
import org.fluentness.view.desktop.SwingViewRegistry;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;

public class DesktopController extends AbstractDesktopController<Desktop> {

    private Persistence persistence;

    public DesktopController(Persistence persistence) {
        super(Desktop.class);
        this.persistence = persistence;
    }

    public void test(CaretEvent caretEvent) {

        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    public void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
