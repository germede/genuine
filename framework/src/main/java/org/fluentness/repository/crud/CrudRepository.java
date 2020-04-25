package org.fluentness.repository.crud;

import org.fluentness.repository.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M extends Model> implements Repository {

    protected final Persistence persistence;
    protected final Class<M> modelClass;

    protected CrudRepository(Persistence persistence, Class<M> modelClass) {
        this.persistence = persistence;
        this.modelClass = modelClass;
    }

    public M select(long id) {
        return persistence.retrieve(modelClass, id);
    }

    public List<M> select() {
        return persistence.retrieve(modelClass);
    }

    public List<M> selectByField(String field, Object value) {
        return persistence.retrieve(modelClass, field + " = " + "'" + value + "'");
    }

    public int insert(M model) {
        return persistence.persist(model);
    }

    public int update(M model) {
        return persistence.persist(model);
    }

    public int delete(M model) {
        return persistence.remove(model);
    }


}
