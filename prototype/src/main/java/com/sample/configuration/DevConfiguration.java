package com.sample.configuration;

import org.fluentness.authenticator.BasicAuthenticator;
import org.fluentness.configuration.AbstractConfiguration;
import org.fluentness.logger.LogLevel;
import org.fluentness.logger.Logger;
import org.fluentness.persistence.Persistence;
import org.fluentness.server.Server;

public class DevConfiguration extends AbstractConfiguration {

    @Override
    protected void configure() {
        set(Server.PORT, 8000);
        set(Logger.LEVEL, LogLevel.DEBUG);
        set(Logger.CONSOLE, true);
        set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party");
        set(Persistence.USERNAME, "party");
        set(Persistence.PASSWORD, "party");
        set(BasicAuthenticator.USERNAME, "admin");
        set(BasicAuthenticator.PASSWORD, "admin");
    }
}
