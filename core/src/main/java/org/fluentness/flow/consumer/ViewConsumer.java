package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.view.ViewProducer;

public interface ViewConsumer<T extends ViewProducer> extends Consumer {

    default T views() {
        return (T) Fluentness.getFlow().getProducer(ViewProducer.class);
    }
}
