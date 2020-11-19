package org.fluentness.application;

import org.fluentness.Application;
import org.fluentness.controller.DesktopController;
import org.fluentness.view.DesktopView;

public abstract class DesktopApplication implements Application {

    private final DesktopController[] controllers;

    public DesktopApplication(DesktopController... controllers) {
        this.controllers = controllers;
    }

    @Override
    public void run(String[] args) {
        for (DesktopController controller : controllers) {
            ((DesktopView)controller.getView()).getJFrame();
        }
    }
}
