package org.fluentness.application;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.persistence.JdbcPersistence;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Application.Services({
    JdbcPersistence.class,
    ConfigurationImpl.class,
    JulLog.class,
})
public interface Application {

    void run(String[] args) throws Exception;

    // By using this annotation on the application class hierarchy,
    // the provided service implementations are registered for possible instantiation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Services {
        Class<? extends Service>[] value();
    }
}
