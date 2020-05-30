package org.fluentness;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.Services;
import org.fluentness.service.log.AndroidLog;

@Services({
    AndroidLog.class,
})
public abstract class AbstractMobile implements Application {

    private final AbstractMobileController[] controllers;

    public AbstractMobile(AbstractMobileController... controllers) {
        this.controllers = controllers;
    }

    public AbstractMobileController[] getControllers() {
        return controllers;
    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
