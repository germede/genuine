package org.fluentness.data;

import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;

public interface DataConsumer {

    default boolean canRepositoryBeConsumed(Class<?> key) {
        return Data.instance.has(key);
    }

    default <R extends Repository> R consumeRepository(Class<R> repository) {
        return (R) Data.instance.get(repository);
    }

    default <M extends Model> Repository<M> consumeRepositoryByModel(Class<M> model) {
        return Data.instance.get(model);
    }
}
