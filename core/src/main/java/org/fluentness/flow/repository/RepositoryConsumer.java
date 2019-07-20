package org.fluentness.flow.repository;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Consumer;

public interface RepositoryConsumer<T extends RepositoryProvider> extends Consumer {

    default T repositories() {
        return (T) Fluentness.flow.getProvider(RepositoryProvider.class);
    }
}
