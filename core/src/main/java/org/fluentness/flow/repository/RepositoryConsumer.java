package org.fluentness.flow.repository;

import org.fluentness.base.generics.Consumer;
import org.fluentness.flow.Flow;

public interface RepositoryConsumer<T extends RepositoryProvider> extends Consumer {

    default T repositories() {
        return (T) Flow.instance.getProvider(RepositoryProvider.class);
    }
}
