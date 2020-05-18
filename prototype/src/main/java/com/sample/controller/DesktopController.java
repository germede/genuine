package com.sample.controller;

import org.fluentness.controller.AbstractDesktopController;

import java.awt.event.ActionEvent;

public class DesktopController extends AbstractDesktopController<Desktop> {

    public DesktopController(Desktop desktop) {
        super(desktop);
        desktop.button.addActionListener(this::onButtonClick);
    }

    private void onButtonClick(ActionEvent actionEvent) {
        System.out.println("TEST");
    }

}
