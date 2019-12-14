package com.sample.configuration;

import org.fluentness.authenticator.BasicAuthenticator;
import org.fluentness.logger.LogLevel;
import org.fluentness.logger.Logger;
import org.fluentness.persistence.Persistence;
import org.fluentness.server.Server;

public class Configuration {

    @Override
    public void configure(org.fluentness.configuration.Configuration configuration) {
        configuration.set(Server.PORT, 8000);
        configuration.set(Logger.LEVEL, LogLevel.DEBUG);
        configuration.set(Logger.CONSOLE, true);
        configuration.set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party");
        configuration.set(Persistence.USERNAME, "party");
        configuration.set(Persistence.PASSWORD, "party");
        configuration.set(BasicAuthenticator.USERNAME, "admin");
        configuration.set(BasicAuthenticator.PASSWORD, "admin");
        switch (getEnvironment()) {
            case PROD:
                configuration.set(Server.PORT, 80);
                configuration.set(Logger.LEVEL, LogLevel.ERROR);
                configuration.set(Logger.CONSOLE, true);
        }
    }
}
