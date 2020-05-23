package org.fluentness.prototype;

import org.fluentness.AbstractDesktop;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.controller.DesktopController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;

@Services(Configuration.class)
public class Desktop extends AbstractDesktop {

    public Desktop(DesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Desktop.class, args);
    }
}
