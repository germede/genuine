package com.sample.service;

import org.fluentness.Application;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configurator.AbstractConfigurator;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;

public class Configurator extends AbstractConfigurator {

    @Override
    protected void configure(Application.Environment environment) {
        if (environment.equals(Application.Environment.DEV)) {
            set(Server.server_port, 8000);
            set(Logger.logger_level, LogLevel.DEBUG);
            set(Logger.logger_console, true);
            set(Persistence.persistence_unit, "bookLibraryPU");
            set(BasicAuthenticator.basic_authenticator_username, "admin");
            set(BasicAuthenticator.basic_authenticator_password, "admin");
        }

        if (environment.equals(Application.Environment.PROD)) {
            set(Server.server_port, 80);
            set(Logger.logger_level, LogLevel.ERROR);
            set(Logger.logger_console, true);
        }
    }

}
