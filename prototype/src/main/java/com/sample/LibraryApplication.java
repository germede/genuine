package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;

import static org.fluentness.Application.Environment.DEV;
import static org.fluentness.Application.Platform.DESKTOP;

public class LibraryApplication implements Application {

    @Override
    public void configure(Configurator configurator) {
        configurator.set(Server.server_port, 8000);
        configurator.set(Logger.logger_level, LogLevel.DEBUG);
        configurator.set(Logger.logger_console, true);
        configurator.set(Persistence.persistence_unit, "bookLibraryPU");
        configurator.set(BasicAuthenticator.basic_authenticator_username, "admin");
        configurator.set(BasicAuthenticator.basic_authenticator_password, "admin");
        switch (getEnvironment()) {
            case PROD:
                configurator.set(Server.server_port, 80);
                configurator.set(Logger.logger_level, LogLevel.ERROR);
                configurator.set(Logger.logger_console, true);
        }

    }

    @Override
    public Environment getEnvironment() {
        return DEV;
    }

    @Override
    public Platform getPlatform() {
        return DESKTOP;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
