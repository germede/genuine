package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;


public class LibraryApplication implements Application {

    @Override
    public void configure(Configuration configuration) {
        configuration.set(Server.PORT, 8000);
        configuration.set(Logger.LEVEL, LogLevel.DEBUG);
        configuration.set(Logger.CONSOLE, true);
        configuration.set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party");
        configuration.set(Persistence.USERNAME, "party");
        configuration.set(Persistence.PASSWORD, "party");
        configuration.set(BasicAuthenticator.USERNAME, "admin");
        configuration.set(BasicAuthenticator.PASSWORD, "admin");
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication(), args);
    }
}
