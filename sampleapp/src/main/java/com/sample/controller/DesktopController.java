package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.DesktopEvent;
import org.fluentness.controller.desktop.DesktopView;

import java.awt.event.ActionEvent;

public class DesktopController extends AbstractDesktopController {

    private Desktop desktop;

    public DesktopController(Desktop desktop) {
        this.desktop = desktop;
    }

    @Action(trigger = DesktopEvent.START)
    public DesktopView start() {
        return desktop.main();
    }

    public void showInfoMessage(ActionEvent event) {

    }
}
