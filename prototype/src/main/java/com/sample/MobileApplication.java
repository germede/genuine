package com.sample;

import org.fluentness.AbstractMobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class MobileApplication extends AbstractMobileApplication {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(MobileApplication.class, args);
    }
}
