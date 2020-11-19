package org.fluentness.prototype;

import org.fluentness.application.DesktopApplication;
import org.fluentness.service.injector.ConstructorInjector;

//@Application.Services(Configuration.class)
public class WGDesktopApplication extends DesktopApplication {

    public WGDesktopApplication(WGDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws Exception {
        new ConstructorInjector().inject(WGDesktopApplication.class).run(args);
    }
}
