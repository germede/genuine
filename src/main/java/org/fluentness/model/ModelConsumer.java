package org.fluentness.model;

import org.fluentness.Fluentness;
import org.fluentness.common.components.Consumer;

public interface ModelConsumer<T extends ModelProvider> extends Consumer {

    default T models() {
        return (T) Fluentness.INSTANCE.models;
    }
}
