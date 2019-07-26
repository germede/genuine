package org.fluentness.flow;

import org.fluentness.flow.producer.Component;
import org.fluentness.flow.producer.Producer;

import java.util.Map;

public final class Flow {

    private final Map<Class, Producer> producers;

    Flow(Map<Class, Producer> producers) {
        this.producers = producers;
    }

    public <C extends Component> Producer<C> getProducer(Class<C> componentClass) {
        return producers.get(componentClass);
    }
}
