package org.fluentness.repository;

import org.fluentness.model.Model;

public abstract class AbstractReadRepository<M extends Model> implements Repository<M> {

    protected final Class<M> modelClass;

    public AbstractReadRepository(Class<M> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public Class<M> getModelClass() {
        return modelClass;
    }


}
