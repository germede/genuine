package org.fluentness.application;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.view.FluentnessActivity;

@Application.Services({
    AndroidLog.class,
})
public abstract class AbstractMobileApplication implements Application {

    public static AbstractMobileApplication application;
    public static FluentnessActivity context;

    private final AbstractMobileController[] controllers;

    public AbstractMobileApplication(AbstractMobileController... controllers) {
        this.controllers = controllers;
        application = this;
    }

    public AbstractMobileController[] getControllers() {
        return controllers;
    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
