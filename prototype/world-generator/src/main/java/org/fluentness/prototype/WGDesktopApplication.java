package org.fluentness.prototype;

import org.fluentness.Fluentness;
import org.fluentness.application.DesktopApplication;
import org.fluentness.service.injector.InjectorException;

//@Application.Services(Configuration.class)
public class WGDesktopApplication extends DesktopApplication {

    public WGDesktopApplication(WGDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws InjectorException {
        Fluentness.launch(WGDesktopApplication.class, args);
    }
}
