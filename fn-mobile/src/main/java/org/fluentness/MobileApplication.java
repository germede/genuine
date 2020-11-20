package org.fluentness;

import org.fluentness.controller.MobileController;
import org.fluentness.service.injector.DefaultImplementations;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.service.log.Log;
import org.fluentness.view.FluentnessActivity;

public abstract class MobileApplication implements Application {

    static {
        DefaultImplementations.set(Log.class, AndroidLog.class);
    }

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
