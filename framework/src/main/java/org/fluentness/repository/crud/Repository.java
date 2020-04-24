package org.fluentness.repository.crud;

import org.fluentness.Fluentness;
import org.fluentness.repository.Model;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class Repository<M extends Model> implements org.fluentness.repository.Repository {

    protected final Class<M> modelClass;
    protected final Persistence persistence;

    protected Repository() {
        Class<M> modelClass = null;
        String tableName = null;
        Persistence persistence = null;
        try {
            // todo make something diff
            modelClass = (Class<M>) Class.forName(getClass().getCanonicalName().replace("Repository", ""));
            persistence = Fluentness.getInstance(Persistence.class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        this.modelClass = modelClass;
        this.persistence = persistence;
    }

    public Class<M> getModelClass() {
        return modelClass;
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
