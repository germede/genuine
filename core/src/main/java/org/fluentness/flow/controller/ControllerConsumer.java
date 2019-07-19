package org.fluentness.flow.controller;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface ControllerConsumer<T extends ControllerProvider> extends Consumer {
    
    default T controller() {
        return (T) Flow.instance.getProvider(ControllerProvider.class);
    }
}
