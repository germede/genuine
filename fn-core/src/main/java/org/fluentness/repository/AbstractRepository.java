package org.fluentness.repository;

import org.fluentness.model.Model;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Condition;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class AbstractRepository<M extends Model> implements Repository {

    protected final Persistence persistence;
    protected final Log log;
    protected final Class<M> modelClass;

    public AbstractRepository(Persistence persistence, Log log, Class<M> modelClass) {
        this.persistence = persistence;
        this.log = log;
        this.modelClass = modelClass;
    }

    public Class<M> getModelClass() {
        return modelClass;
    }

    public M select(int id) {
        return persistence.retrieve(modelClass, id);
    }

    public List<M> select() {
        return persistence.retrieve(modelClass);
    }

    public List<M> selectByField(String field, Object value) {
        return persistence.retrieve(modelClass, eq(field, value));
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

    public int delete(int id) {
        return persistence.remove(modelClass, id);
    }
    
    public static Condition eq(String field, Object value) {
        return new Condition(field, "=", value);
    }

    public static Condition lt(String field, Object value) {
        return new Condition(field, "<", value);
    }

    public static Condition gt(String field, Object value) {
        return new Condition(field, ">", value);
    }

    public static Condition in(String field, Object value) {
        return new Condition(field, " IN ", value);
    }

}
