package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.flow.producer.Component;
import org.fluentness.flow.producer.Producer;

import java.util.HashMap;
import java.util.Map;

public final class FlowDefinition {

    private Map<Class, Producer> producers = new HashMap();

    public <P extends Component> ForComponent<P> forComponent(Class<P> componentClass) throws DefinitionException {

        if (componentClass.equals(Component.class)) {
            throw new DefinitionException("The class Component itself cannot be declared as a component");
        }
        if (producers.containsKey(componentClass)) {
            throw new DefinitionException("Component class %s was already defined");
        }

        return new ForComponent<>(componentClass, this);
    }

    public Flow build() {
        return new Flow(producers);
    }

    public static final class ForComponent<P extends Component> {

        private final Class<P> modelClass;
        private final FlowDefinition builder;

        private ForComponent(Class<P> componentClass, FlowDefinition builder) {
            this.modelClass = componentClass;
            this.builder = builder;
        }

        public FlowDefinition useProducer(Producer<P> producer) {
            builder.producers.put(modelClass, producer);
            Fluentness.addOnionLayer(producer.getClass());
            return builder;
        }
    }
}
