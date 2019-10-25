package org.fluentness.repository;

import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M> implements Repository {

    protected Persistence persistence;

    public CrudRepository(Persistence persistence) {
        this.persistence = persistence;
    }

    protected abstract Class<M> getModelClass();

    public void create(M book) {
        persistence.persist(book);
    }

    public void update(M book) {
        persistence.persist(book);
    }

    public void delete(M book) {
        persistence.remove(book);
    }

    public M findById(int id) {
        return persistence.find(getModelClass(), id);
    }

    public List<M> findAll() {
        return persistence.query("SELECT * FROM " + getModelClass().getSimpleName()).getResultList();
    }

}
