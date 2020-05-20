package com.sample.service;

import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.display.Display;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class MapConfiguration extends ConfigurationImpl {

    public MapConfiguration() {
        set(Server.PORT, 8000);
        set(Server.HOST, "0.0.0.0");
        set(Router.SINGLE_PAGE_MODE, false);
        set(Log.LEVEL, LogLevel.DEBUG);
        set(Log.CONSOLE, true);
        set(
            JdbcPersistence.URL_PARAMETER_QUERY,
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        );
        set(JdbcPersistence.DATABASE, "workstation");
        set(JdbcPersistence.USERNAME, "workstation");
        set(JdbcPersistence.PASSWORD, "workstation");
        set(Display.TITLE, "Forest");
        set(Display.WIDTH, 1800);
        set(Display.HEIGHT, 900);
        set(Display.FULLSCREEN, false);
    }


}
