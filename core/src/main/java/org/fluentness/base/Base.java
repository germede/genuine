package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.Service;

public class Base extends Architecture<Service, Service> {

    public Base(Fluentness app) {
        super(app);
    }

    @Override
    protected void validateDefinition(Class<Service> key, Class<Service> value) throws DefinitionException {
        if (key.equals(Service.class)) {
            throw new DefinitionException(
                "The interface Service itself cannot be declared as a service, but its sub-interfaces"
            );
        }
        if (defined.containsKey(key)) {
            throw new DefinitionException("Service %s was already defined");
        }
        if (!key.isInterface()) {
            throw new DefinitionException(
                "Service %s must be an interface",
                key.getSimpleName()
            );
        }
    }

}
