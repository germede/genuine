package org.fluentness.repository;

import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Condition;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class AbstractRepository<M extends Model> implements Repository<M> {

    protected final Persistence persistence;
    protected final Log log;
    protected final Class<M> modelClass;

    public AbstractRepository(Persistence persistence, Log log, Class<M> modelClass) {
        this.persistence = persistence;
        this.log = log;
        this.modelClass = modelClass;
    }

    @Override
    public Class<M> getModelClass() {
        return modelClass;
    }

    @Override
    public M select(int id) {
        return persistence.retrieve(modelClass, id);
    }

    @Override
    public List<M> select() {
        return persistence.retrieve(modelClass);
    }

    @Override
    public List<M> selectByField(String field, Object value) {
        return persistence.retrieve(modelClass, Condition.eq(field, value));
    }

    @Override
    public int insert(M model) {
        return persistence.persist(model);
    }

    @Override
    public int update(M model) {
        return persistence.persist(model);
    }

    @Override
    public int delete(M model) {
        return persistence.remove(model);
    }

    @Override
    public int delete(int id) {
        return persistence.remove(modelClass, id);
    }

}
