package org.fluentness;

import org.fluentness.controller.MobileController;
import org.fluentness.service.Services;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.view.FluentnessActivity;

@Services({
    AndroidLog.class,
})
public abstract class MobileApplication implements Application {

    public static MobileApplication application;
    public static FluentnessActivity context;

    private final MobileController[] controllers;

    public MobileApplication(MobileController... controllers) {
        this.controllers = controllers;
        application = this;
    }

    public MobileController[] getControllers() {
        return controllers;
    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
