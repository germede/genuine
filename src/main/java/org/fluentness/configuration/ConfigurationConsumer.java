package org.fluentness.configuration;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface ConfigurationConsumer<T extends ConfigurationProducer> extends Consumer {

    default T configuration() {
        return (T) Fluentness.INSTANCE.configurations;
    }
}
