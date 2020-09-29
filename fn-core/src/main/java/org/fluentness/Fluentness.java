package org.fluentness;

import org.fluentness.application.Application;
import org.fluentness.service.instantiation.InstantiationImpl;

public final class Fluentness {
    public static void launch(Class<? extends Application> applicationClass, String[] args) {
        try {
            new InstantiationImpl().instantiate(applicationClass).run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}