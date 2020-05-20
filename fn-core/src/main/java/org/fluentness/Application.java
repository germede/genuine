package org.fluentness;

import org.fluentness.controller.ConsoleController;
import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.log.JulLog;

@Src(
    services = {
        ConfigurationImpl.class,
        JulLog.class
    },
    controllers = ConsoleController.class
)
public interface Application {

    void run(String[] args) throws Exception;

    interface Component {
        // Application components are the only objects that are injectable by Fluentness
    }

}
