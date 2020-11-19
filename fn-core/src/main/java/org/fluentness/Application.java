package org.fluentness;

import org.fluentness.service.Services;
import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.JdbcPersistence;

@Services({
    JdbcPersistence.class,
    ConfigurationImpl.class,
    JulLog.class,
})
public interface Application {
    void run(String[] args) throws Exception;
}
