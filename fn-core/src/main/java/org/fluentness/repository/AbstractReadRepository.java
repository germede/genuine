package org.fluentness.repository;

import org.fluentness.model.Model;

public abstract class AbstractReadRepository<M extends Model> implements Repository<M> {

    @Override
    public final Class<M> getModelClass() {
        return null;
    }

}
