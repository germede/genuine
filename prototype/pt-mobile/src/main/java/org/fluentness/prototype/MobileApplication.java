package org.fluentness.prototype;

import org.fluentness.application.AbstractMobileApplication;
import org.fluentness.Fluentness;
import org.fluentness.service.instantiation.InstantiationException;

public class MobileApplication extends AbstractMobileApplication {

    public MobileApplication(MobileController controller) {
        super(controller);
    }

    public static void main(String[] args) throws InstantiationException {
        Fluentness.launch(MobileApplication.class, args);
    }
}
