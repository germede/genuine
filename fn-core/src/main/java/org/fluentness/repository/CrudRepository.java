package org.fluentness.repository;

import org.fluentness.model.PersistableModel;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M extends PersistableModel> implements Repository<M> {

    protected final Class<M> modelClass;
    protected final Persistence persistence;

    public CrudRepository(Class<M> modelClass, Persistence persistence) {
        this.persistence = persistence;
        this.modelClass = modelClass;
    }

    @Override
    public List<M> selectAll() {
        return persistence.retrieve(modelClass);
    }

    public M select(long id) {
        return persistence.retrieve(modelClass, id);
    }

    public M selectFirst(String field, Object value) {
        return selectByField(field, value).get(0);
    }

    public List<M> selectByField(String field, Object value) {
        if (value instanceof String) return persistence.retrieve(modelClass, field + "='" + value + "'");
        return persistence.retrieve(modelClass, field + "=" + value);
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

    public int delete(long id) {
        return persistence.remove(modelClass, id);
    }

}
