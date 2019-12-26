package org.fluentness.repository.crud;

import org.fluentness.repository.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.Persistence;

public abstract class AbstractCrudRepository<M extends Model> implements Repository<M> {

    protected final Class<M> modelClass;
    protected final String tableName;
    protected final Persistence persistence;

    protected AbstractCrudRepository(Class<M> modelClass, Persistence persistence) {
        this.modelClass = modelClass;
        this.tableName = modelClass.getSimpleName().toLowerCase();
        this.persistence = persistence;
    }


}
