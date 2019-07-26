package org.fluentness.flow;

import org.fluentness.base.common.ArchitectureBuilder;
import org.fluentness.base.common.exception.BuildException;
import org.fluentness.flow.provider.Provider;

public class FlowBuilder extends ArchitectureBuilder<Flow, Provider> {

    @Override
    protected void validate(Class<Provider> key, Provider value) throws BuildException {
        if (key.equals(Provider.class)) {
            throw new BuildException("The class Provider itself cannot be declared as a component");
        }
        if (instances.containsKey(key)) {
            throw new BuildException("Provider %s was already defined");
        }
    }

    @Override
    public Flow build() {
        return new Flow(instances);
    }

}
