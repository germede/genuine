package org.fluentness;

import org.fluentness.application.Application;
import org.fluentness.service.injector.InjectorImpl;

public final class Fluentness {
    public static void launch(Class<? extends Application> applicationClass, String[] args) {
        try {
            new InjectorImpl().inject(applicationClass).run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}