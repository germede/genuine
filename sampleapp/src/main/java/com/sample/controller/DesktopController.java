package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController {

    private Desktop desktop;

    public DesktopController(Desktop desktop) {
        this.desktop = desktop;
    }
}
