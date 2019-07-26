package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.controller.ControllerProducer;

public interface ControllerConsumer<T extends ControllerProducer> extends Consumer {

    default T controller() {
        return (T) Fluentness.getFlow().getProducer(ControllerProducer.class);
    }
}
