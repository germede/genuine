package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.view.AbstractDesktopView;

public abstract class AbstractDesktop implements Application {

    private final AbstractDesktopController[] controllers;

    public AbstractDesktop(AbstractDesktopController... controllers) {
        this.controllers = controllers;
    }

    @Override
    public void run(String[] args) {
        for (AbstractDesktopController controller : controllers) {
            ((AbstractDesktopView)controller.getView()).getJFrame();
        }
    }
}
