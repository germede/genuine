package org.fluentness.base;

import org.fluentness.base.common.ArchitectureBuilder;
import org.fluentness.base.common.exception.BuildException;
import org.fluentness.base.service.Service;

public class BaseBuilder extends ArchitectureBuilder<Base, Service> {

    @Override
    protected void validate(Class<Service> key, Service value) throws BuildException {
        if (key.equals(Service.class)) {
            throw new BuildException(
                "The interface Service itself cannot be declared as a service, but its sub-interfaces"
            );
        }
        if (instances.containsKey(key)) {
            throw new BuildException("Service %s was already defined");
        }
        if (!key.isInterface()) {
            throw new BuildException(
                "Service %s must be an interface",
                key.getSimpleName()
            );
        }
    }

    @Override
    public Base build() {
        return new Base(instances);
    }

}
