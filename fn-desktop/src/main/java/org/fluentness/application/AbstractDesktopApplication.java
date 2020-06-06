package org.fluentness.application;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.view.AbstractDesktopView;

public abstract class AbstractDesktopApplication implements Application {

    private final AbstractDesktopController[] controllers;

    public AbstractDesktopApplication(AbstractDesktopController... controllers) {
        this.controllers = controllers;
    }

    @Override
    public void run(String[] args) {
        for (AbstractDesktopController controller : controllers) {
            ((AbstractDesktopView)controller.getView()).getJFrame();
        }
    }
}
