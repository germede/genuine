package org.fluentness.prototype;

import org.fluentness.application.DesktopApplication;

public class WGDesktopApplication extends DesktopApplication {

    public WGDesktopApplication(WGDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws Exception {
        new WGDesktopApplication(
            new WGDesktopController(
                new WGDesktopView()
            )
        ).run(args);
    }
}
