package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;

public final class Data extends Architecture<Repository> {

    // per definition a singleton, can only be accessed via consumer
    private final static Data instance = new Data();

    // public but safe, as fluentness instance is required, which has private constructor
    public static Data getInstance(Fluentness proxy) {
        return instance;
    }

    // avoids unintended instantiations
    private Data() {

    }

    @Override
    protected Class<Repository> getIClass() {
        return Repository.class;
    }

    @Override
    protected Class<? extends Repository>[] getKeysThatWillPointTo(Repository instance) {
        return array(
            instance.getModelClass(),
            instance.getClass()
        );
    }

    public interface Consumer {

        default boolean canRepositoryBeConsumed(Class<?> key) {
            return instance.has(key);
        }

        default <R extends Repository> R repository(Class<R> repository) {
            return (R) instance.get(repository);
        }

        default <M extends Model> Repository<M> consumeRepositoryByModel(Class<M> model) {
            return instance.get(model);
        }
    }
}
