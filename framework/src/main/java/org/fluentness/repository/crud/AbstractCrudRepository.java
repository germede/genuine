package org.fluentness.repository.crud;

import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class AbstractCrudRepository<M> implements Repository<M> {

    protected Persistence persistence;

    public AbstractCrudRepository(Persistence persistence) {
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
        return persistence.query("SELECT e FROM " + getModelClass().getSimpleName() + " e").getResultList();
    }

}
