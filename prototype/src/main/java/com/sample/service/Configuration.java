package com.sample.service;

import org.fluentness.Application;
import org.fluentness.service.configuration.AbstractConfiguration;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class Configuration extends AbstractConfiguration {

    @Override
    protected void configure() {
        set(Application.NAME, "WorkStation");
        set(Server.PORT, 8000);
        set(Server.HOST, "0.0.0.0");
        set(Router.SINGLE_PAGE_MODE, false);
        set(Log.LEVEL, LogLevel.DEBUG);
        set(Log.CONSOLE, true);
        set(JdbcPersistence.URL_PARAMETER_QUERY, "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        set(JdbcPersistence.DATABASE, "workstation");
        set(JdbcPersistence.USERNAME, "workstation");
        set(JdbcPersistence.PASSWORD, "workstation");
    }
}
