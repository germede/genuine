package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.view.swing.SwingTemplate;

public abstract class AbstractDesktop implements Application {

    private final AbstractDesktopController[] controllers;

    public AbstractDesktop(AbstractDesktopController... controllers) {
        this.controllers = controllers;
    }

    @Override
    public void run(String[] args) {
        for (AbstractDesktopController controller : controllers) {
            ((SwingTemplate) controller.getView().getTemplate()).render();
        }
    }
}
