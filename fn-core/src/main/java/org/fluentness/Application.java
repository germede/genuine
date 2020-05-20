package org.fluentness;

import org.fluentness.service.Services;
import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.FilePersistence;

@Services({
    ConfigurationImpl.class,
    JulLog.class,
    FilePersistence.class,
})
public interface Application {

    void run(String[] args) throws Exception;

}
