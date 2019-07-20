package org.fluentness.flow.controller;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface ControllerConsumer<T extends ControllerProvider> extends Consumer {
    
    default T controller() {
        return (T) Fluentness.flow.getProvider(ControllerProvider.class);
    }
}
