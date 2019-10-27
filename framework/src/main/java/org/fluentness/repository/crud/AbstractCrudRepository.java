package org.fluentness.repository.crud;

import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.PersistenceService;

import java.util.List;

public abstract class AbstractCrudRepository<M> implements Repository {

    protected PersistenceService persistenceService;

    public AbstractCrudRepository(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
    }

    protected abstract Class<M> getModelClass();

    public void create(M book) {
        persistenceService.persist(book);
    }

    public void update(M book) {
        persistenceService.persist(book);
    }

    public void delete(M book) {
        persistenceService.remove(book);
    }

    public M findById(int id) {
        return persistenceService.find(getModelClass(), id);
    }

    public List<M> findAll() {
        return persistenceService.query("SELECT e FROM " + getModelClass().getSimpleName() + " e").getResultList();
    }

}
