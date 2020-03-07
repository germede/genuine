package com.sample.service;

import org.fluentness.Application;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;

public class LibraryConfigurator extends Configurator {

    @Override
    protected void configure() {
        set(Application.NAME, "Library");
        set(Server.PORT, 8000);
        set(Server.SINGLE_PAGE_MODE, false);
        set(Logger.LEVEL, LogLevel.DEBUG);
        set(Logger.CONSOLE, true);
        set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party");
        set(Persistence.USERNAME, "party");
        set(Persistence.PASSWORD, "party");
        set(BasicAuthenticator.USERNAME, "admin");
        set(BasicAuthenticator.PASSWORD, "admin");
    }
}
