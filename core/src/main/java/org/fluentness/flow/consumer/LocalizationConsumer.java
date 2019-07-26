package org.fluentness.flow.consumer;

import org.fluentness.Fluentness;
import org.fluentness.flow.producer.localization.LocalizationProducer;

public interface LocalizationConsumer<T extends LocalizationProducer> extends Consumer {

    default T locales() {
        return (T) Fluentness.getFlow().getProducer(LocalizationProducer.class);
    }
}
