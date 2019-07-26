package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.Service;

public class Flow extends Architecture<org.fluentness.flow.producer.Component, org.fluentness.flow.producer.Producer> {

    public Flow(Fluentness app) {
        super(app);
    }

    @Override
    protected void validateDefinition(Class<org.fluentness.flow.producer.Component> key, Class<org.fluentness.flow.producer.Producer> value) throws DefinitionException {
        if (key.equals(org.fluentness.flow.producer.Component.class)) {
            throw new DefinitionException("The class Component itself cannot be declared as a component");
        }
        if (defined.containsKey(key)) {
            throw new DefinitionException("Component class %s was already defined");
        }
    }

    public <C extends Service> ForComponent<C> forService(Class<C> componentClass) {
        return new ForComponent<>(componentClass);
    }

    public final class ForComponent<C extends Service> {

        private final Class<C> componentClass;

        private ForComponent(Class<C> componentClass) {
            this.componentClass = componentClass;
        }

        public Flow useImplementation(Class<? extends C> serviceImplementation) {
            defined.put((Class<Service>) componentClass, (Class<Service>) serviceImplementation);
            return Flow.this;
        }
    }
}
