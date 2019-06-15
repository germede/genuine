package org.fluentness.model;

import org.fluentness.Fluentness;
import org.fluentness.base.onion.Consumer;

public interface ModelConsumer<T extends ModelProducer> extends Consumer {

    default T models() {
        return (T) Fluentness.INSTANCE.models;
    }
}
