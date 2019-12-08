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
import static org.fluentness.Application.Platform.WEB;

public class LibraryApplication implements Application {

    @Override
    public void configure(Configurator configurator) {
        configurator.set(Server.PORT, 8000);
        configurator.set(Logger.LEVEL, LogLevel.DEBUG);
        configurator.set(Logger.CONSOLE, true);
        configurator.set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party");
        configurator.set(Persistence.USERNAME, "party");
        configurator.set(Persistence.PASSWORD, "party");
        configurator.set(BasicAuthenticator.USERNAME, "admin");
        configurator.set(BasicAuthenticator.PASSWORD, "admin");
        switch (getEnvironment()) {
            case PROD:
                configurator.set(Server.PORT, 80);
                configurator.set(Logger.LEVEL, LogLevel.ERROR);
                configurator.set(Logger.CONSOLE, true);
        }

    }

    @Override
    public Environment getEnvironment() {
        return DEV;
    }

    @Override
    public Platform getPlatform() {
        return WEB;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
