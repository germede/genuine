package org.fluentness.base;

import org.fluentness.base.service.Service;

public interface BaseConsumer {

    default boolean canServiceBeConsumed(Class<? extends Service> service) {
        return Base.instance.has(service);
    }

    default <S extends Service> S consumeService(Class<S> service) {
        return (S) Base.instance.get(service);
    }
}
