package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.style.StyleProducer;

public interface StyleConsumer<T extends StyleProducer> extends Consumer {

    default T styles() {
        return (T) Fluentness.getFlow().getProducer(StyleProducer.class);
    }
}
