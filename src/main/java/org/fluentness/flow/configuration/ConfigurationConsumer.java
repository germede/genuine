package org.fluentness.flow.configuration;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface ConfigurationConsumer<T extends ConfigurationProvider> extends Consumer {

    default T configurations() {
        return (T) Fluentness.INSTANCE.configurations;
    }
}
