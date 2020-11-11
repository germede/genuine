package org.fluentness.prototype.service;

import org.fluentness.service.configuration.BaseConfiguration;
import org.fluentness.service.dispatcher.Dispatcher;
import org.fluentness.service.dispatcher.ResourceDispatcher;
import org.fluentness.service.log.Log;
import org.fluentness.service.log.LogLevel;
import org.fluentness.service.persistence.Persistence;

public class Configuration extends BaseConfiguration {

    @Override
    protected void configure() {
        set(ResourceDispatcher.INLINE_RESOURCES, false);
        set(Log.LEVEL, LogLevel.INFO);
        set(Dispatcher.SINGLE_PAGE_MODE, false);
        set(Persistence.DRIVER, "mysql");
        set(Persistence.HOST, "localhost");
        set(Persistence.PORT, 3306);
        set(Persistence.URL_PARAMETER_QUERY, "?serverTimezone=UTC");
        set(Persistence.DATABASE, "workstation");
        set(Persistence.USERNAME, "workstation");
        set(Persistence.PASSWORD, "workstation");
    }

}
