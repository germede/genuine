package org.fluentness;

import org.fluentness.controller.AbstractMobileController;

public abstract class AbstractMobile implements Application {

    private final AbstractMobileController controller;

    public AbstractMobile(AbstractMobileController controller) {
        this.controller = controller;
    }

    public AbstractMobileController getController() {
        return controller;
    }

    @Override
    public void run(String[] args) {

    }
}
