package org.fluentness.prototype.service;

import org.fluentness.service.configuration.AbstractMapConfiguration;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class MapConfiguration extends AbstractMapConfiguration {

    public MapConfiguration() {
        set(Server.PORT, 8000);
        set(Server.HOST, "0.0.0.0");
        set(Router.SINGLE_PAGE_MODE, false);
        set(
            JdbcPersistence.URL_PARAMETER_QUERY,
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
        );
        set(JdbcPersistence.DATABASE, "workstation");
        set(JdbcPersistence.USERNAME, "workstation");
        set(JdbcPersistence.PASSWORD, "workstation");
    }

}
