package org.fluentness.prototype.service;

import org.fluentness.service.configuration.AbstractMapConfiguration;
import org.fluentness.service.router.Router;
import org.fluentness.service.server.Server;

public class MapConfiguration extends AbstractMapConfiguration {

    public MapConfiguration() {
        set(Server.PORT, 8000);
        set(Server.HOST, "0.0.0.0");
        set(Router.SINGLE_PAGE_MODE, false);
//        set(
//            Persistence.URL_PARAMETER_QUERY,
//            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
//        );
//        set(Persistence.DRIVER, "workstation");
//        set(Persistence.URL, "workstation");
//        set(Persistence.USERNAME, "workstation");
//        set(Persistence.PASSWORD, "workstation");
    }

}
