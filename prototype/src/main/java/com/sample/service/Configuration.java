package com.sample.service;

import org.fluentness.Application;
import org.fluentness.service.configuration.AbstractConfiguration;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;

public class Configuration extends AbstractConfiguration {

    @Override
    protected void configure() {
        set(Application.NAME, "Library");
        set(Server.PORT, 8000);
        set(Server.SINGLE_PAGE_MODE, false);
        set(Log.LEVEL, LogLevel.DEBUG);
        set(Log.CONSOLE, true);
        set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        set(Persistence.USERNAME, "party");
        set(Persistence.PASSWORD, "party");
    }
}
