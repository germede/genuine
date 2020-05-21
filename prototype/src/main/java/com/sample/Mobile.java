package com.sample;

import org.fluentness.AbstractMobile;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class Mobile extends AbstractMobile {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Mobile.class, args);
    }
}
