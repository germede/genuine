package org.fluentness.repository;

import org.fluentness.model.Model;
import org.fluentness.persistence.Persistence;

import java.util.List;

public abstract class AbstractRepository<M extends Model> implements Repository {
    protected Persistence persistence;

    protected AbstractRepository(Persistence persistence) {
        this.persistence = persistence;
    }

    public List<M> select(Class<M> model) {
        return persistence.select(model, "SELECT * FROM " + model.getSimpleName());
    }

    public List<M> select(Class<M> model, String query, Object... parameters) {
        return persistence.select(model, query, parameters);
    }

    public M select(Class<M> model, int id) {
        return persistence.select(model, "SELECT * FROM " + model.getSimpleName() + " WHERE id = ?", id).get(0);
    }

    public boolean insert(M model) {
        return persistence.insert(model);
    }

    public boolean update(M model) {
        return persistence.update(model);
    }

    public boolean delete(M model) {
        return persistence.delete(model);
    }

}
