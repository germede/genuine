package com.sample;

import com.sample.controller.DesktopDesktopController;
import org.fluentness.AbstractDesktop;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

public class Desktop extends AbstractDesktop {

    public Desktop(DesktopDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Desktop.class, args);
    }
}
