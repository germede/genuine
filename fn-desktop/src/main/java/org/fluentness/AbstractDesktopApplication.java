package org.fluentness;

import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;

import javax.swing.*;
import java.util.List;

public abstract class AbstractDesktopApplication implements Application {

    @Override
    public void provide(Provider provider) {

    }

    @Override
    public void configure(Configuration configuration) {

    }

    @Override
    public void run(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        List<AbstractDesktopController> instances = Fluentness.getInstances(AbstractDesktopController.class);
        for (AbstractDesktopController controller : instances) {
//                controller.getDesktop().getStyle().apply();
            controller.getDesktop().render();
        }
    }
}
