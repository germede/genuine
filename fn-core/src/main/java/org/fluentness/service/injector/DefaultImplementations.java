package org.fluentness.service.injector;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.ConfigurationImpl;
import org.fluentness.service.log.JulLog;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

// Maybe after having sealed classes in Java, this class will not be needed anymore (much more elegant,
// as implementations can be retrieved using reflection and no static mechanism is needed)
public final class DefaultImplementations {
    private static final Map<Class, Class> DEFAULT_IMPLEMENTATIONS = new HashMap<>();
    static {
        set(Persistence.class, JdbcPersistence.class);
        set(Configuration.class, ConfigurationImpl.class);
        set(Log.class, JulLog.class);
    }

    public static <C> void set(Class<C> anInterface, Class<? extends C> anImplementation) {
        if (!anInterface.isInterface()) {
            throw new IllegalArgumentException("first argument is not an interface");
        }
        if (anImplementation.isInterface()) {
            throw new IllegalArgumentException("second argument cannot be an interface");
        }
        DEFAULT_IMPLEMENTATIONS.put(anInterface, anImplementation);
    }

    public static <C> Class<? extends C> get(Class<C> anInterface) {
        return DEFAULT_IMPLEMENTATIONS.get(anInterface);
    }

    private DefaultImplementations() {

    }
}
