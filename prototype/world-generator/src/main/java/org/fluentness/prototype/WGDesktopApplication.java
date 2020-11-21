package org.fluentness.prototype;

import org.fluentness.application.DesktopApplication;

public class WGDesktopApplication extends DesktopApplication {

    public WGDesktopApplication(WGDesktopController controller) {
        super(controller);
    }

    public static void main(String[] args) throws Exception {
        // example of manually instantiating and injecting dependencies instead of using ConstructorInjector
        // allowing us to create native-images with graalvm out of this prototype (no reflection is being used)
        new WGDesktopApplication(
            new WGDesktopController(
                new WGDesktopView()
            )
        ).run(args);
    }
}
