package org.fluentness.prototype;

import org.fluentness.Fluentness;
import org.fluentness.application.DesktopApplication;
import org.fluentness.service.instantiation.InstantiationException;

//@Application.Services(Configuration.class)
public class WGDesktopApplication extends DesktopApplication {

    public WGDesktopApplication(WGDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(WGDesktopApplication.class, args);
    }
}
