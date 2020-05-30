package org.fluentness;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.Services;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.view.FluentnessActivity;

@Services({
    AndroidLog.class,
})
public abstract class AbstractMobile implements Application {

    public static AbstractMobile application;
    public static FluentnessActivity context;

    private final AbstractMobileController[] controllers;

    public AbstractMobile(AbstractMobileController... controllers) {
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
