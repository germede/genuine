package org.fluentness.prototype.swing;

import org.fluentness.Fluentness;
import org.fluentness.application.AbstractDesktopApplication;
import org.fluentness.service.instantiation.InstantiationException;

//@Application.Services(Configuration.class)
public class DesktopApplication extends AbstractDesktopApplication {

    public DesktopApplication(DesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(DesktopApplication.class, args);
    }
}
