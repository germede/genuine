package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.Service;

import java.util.HashMap;
import java.util.Map;

public final class BaseDefinition {

    private final Map<Class<Service>, Service> services = new HashMap();

    public <S extends Service> ForService<S> forService(Class<S> serviceInterface) throws DefinitionException {

        if (serviceInterface.equals(Service.class)) {
            throw new DefinitionException(
                "The interface Service itself cannot be declared as a service, but its sub-interfaces"
            );
        }
        if (services.containsKey(serviceInterface)) {
            throw new DefinitionException("Service %s was already defined");
        }
        if (!serviceInterface.isInterface()) {
            throw new DefinitionException(
                "Service %s must be an interface",
                serviceInterface.getSimpleName()
            );
        }

        return new ForService<>(serviceInterface, this);
    }

    public Base build() {
        return new Base(services);
    }

    public static final class ForService<S extends Service> {

        private final Class<S> serviceInterface;
        private final BaseDefinition builder;

        private ForService(Class<S> serviceInterface, BaseDefinition builder) {
            this.serviceInterface = serviceInterface;
            this.builder = builder;
        }

        public BaseDefinition useImplementation(S serviceImplementation) {
            builder.services.put((Class<Service>) serviceInterface, serviceImplementation);
            Fluentness.addOnionLayer(serviceImplementation.getClass());
            return builder;
        }
    }
}
