package org.fluentness.service;

import org.fluentness.ApplicationComponent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Service extends ApplicationComponent {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface ServiceType {

        Type value();
    }

    // Used mainly by Injector class
    enum Type {

        // Singleton service core implementation which is final and cannot be replaced (see Injector or Loader)
        IRREPLACEABLE,

        // Singleton service core implementation which can be replaced by applications own (see Server or JPA providers)
        REPLACEABLE,

        // Service is not a singleton, so many implementations of it can be injected (see Authenticators or Validators)
        MULTIPLE
    }
}
