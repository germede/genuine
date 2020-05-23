package org.fluentness;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.Services;
import org.fluentness.service.log.AndroidLog;

@Services({
    AndroidLog.class,
})
public abstract class AbstractMobile implements Application {

    private final AbstractMobileController controller;

    public AbstractMobile(AbstractMobileController controller) {
        this.controller = controller;
    }

    public AbstractMobileController getController() {
        return controller;
    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
