package com.sample;

import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class DesktopApplication extends AbstractDesktopApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(DesktopApplication.class, args);
    }
}
