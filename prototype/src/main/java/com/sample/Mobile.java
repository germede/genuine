package com.sample;

import com.sample.controller.MobileController;
import org.fluentness.AbstractMobile;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class Mobile extends AbstractMobile {

    public Mobile(MobileController controller) {
        super(controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Mobile.class, args);
    }
}
