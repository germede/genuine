package org.fluentness.configuration;

import org.fluentness.Fluentness;
import org.fluentness.common.generics.Consumer;

public interface ConfigurationConsumer<T extends ConfigurationProvider> extends Consumer {

    default T configurations() {
        return (T) Fluentness.INSTANCE.configurations;
    }
}
