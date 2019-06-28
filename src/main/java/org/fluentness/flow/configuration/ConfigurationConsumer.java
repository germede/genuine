package org.fluentness.flow.configuration;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface ConfigurationConsumer<T extends ConfigurationProvider> extends Consumer {

    default T configurations() {
        return (T) Flow.call.configurations;
    }
}
