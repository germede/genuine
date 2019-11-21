package org.fluentness.repository.crud;

import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.PersistenceService;

import java.util.List;

public abstract class AbstractCrudRepository<M> implements Repository {

    protected PersistenceService persistence;

    public AbstractCrudRepository(PersistenceService persistence) {
        this.persistence = persistence;
    }

    public void create(M model) {
        persistence.persist(model);
    }

    public void update(M model) {
        persistence.persist(model);
    }

    public void delete(M model) {
        persistence.remove(model);
    }

    public M find(Class<M> modelClass, int id) {
        return persistence.find(modelClass, id);
    }

    public List<M> findAll(Class<M> mClass) {
        return persistence.query("SELECT m FROM " + mClass.getSimpleName() + " m").getResultList();
    }

}
