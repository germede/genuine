package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.view.SwingViewRegistry;
import org.fluentness.controller.desktop.view.component.MenuBarView;
import org.fluentness.controller.desktop.view.style.DesktopStyle;
import org.fluentness.service.persistence.Persistence;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.*;
import java.awt.event.ActionEvent;

import static org.fluentness.controller.desktop.view.SwingViewFactory.*;
import static org.fluentness.controller.desktop.view.style.DesktopStyleFactory.byClass;
import static org.fluentness.controller.desktop.view.style.DesktopStyleFactory.ubuntuStyle;

public class DesktopController extends AbstractDesktopController<Desktop> {

    private final Desktop desktop;
    private final Persistence persistence;

    public DesktopController(Persistence persistence) {
        this.desktop = new Desktop(this);
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
