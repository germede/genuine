package com.sample.service;

import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configuration.AbstractConfiguration;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;

public class LibraryConfiguration extends AbstractConfiguration {

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
