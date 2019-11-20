package org.fluentness.repository.crud;

import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.PersistenceService;

import java.util.List;

public abstract class AbstractCrudRepository<M extends Model> implements Repository {

    protected PersistenceService persistence;

    public AbstractCrudRepository(PersistenceService persistence) {
        this.persistence = persistence;
    }

    public void create(M book) {
        persistence.persist(book);
    }

    public void update(M book) {
        persistence.persist(book);
    }

    public void delete(M book) {
        persistence.remove(book);
    }

    public M find(Class<M> mClass, int id) {
        return persistence.find(mClass, id);
    }

    public List<M> findAll(Class<M> mClass) {
        return persistence.query("SELECT m FROM " + mClass.getSimpleName() + " m").getResultList();
    }

}
