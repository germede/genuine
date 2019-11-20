package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopViewHolder;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;

public class DesktopController extends AbstractDesktopController {

    @Override
    protected DesktopViewHolder initViewHolder() {
        return new Desktop(this);
    }

    void test(CaretEvent caretEvent) {
        JCheckBox checkbox_2 = (JCheckBox) getSwingViewByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    void cutPresed(ActionEvent event) {
        int i = 2;
    }
}
