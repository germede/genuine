package org.fluentness.data;

import org.fluentness.base.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M extends Model> implements Repository<M> {

    protected Persistence persistence;

    public CrudRepository(Persistence persistence) {
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

    public M findById(int id) {
        return persistence.find(getModelClass(), id);
    }

    public List<M> findAll() {
        return persistence.query("SELECT * FROM " + getModelClass().getSimpleName()).getResultList();
    }

}
