package org.fluentness.flow.repository;

import org.fluentness.base.generics.Provider;
import org.fluentness.base.generics.KeyValuePair;
import org.fluentness.flow.locale.Locale;

public abstract class RepositoryProvider extends Provider<Locale> {

    @Override
    public Class<Locale> getProducedComponentType() {
        return Locale.class;
    }

    protected  <M> Repository<M> forModel(Class<M> modelClass, KeyValuePair<String>... queries) {
        return new Repository<>(modelClass, queries);
    }

}
