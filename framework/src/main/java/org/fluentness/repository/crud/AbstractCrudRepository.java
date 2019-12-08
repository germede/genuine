package org.fluentness.repository.crud;

import org.fluentness.repository.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public abstract class AbstractCrudRepository<M extends Model> implements Repository {

    protected Persistence persistence;

    public AbstractCrudRepository(Persistence persistence) {
        this.persistence = persistence;
    }
//
//    public void create(M model) {
//        persistence.persist(model);
//    }
//
//    public void update(M model) {
//        persistence.persist(model);
//    }
//
//    public void delete(M model) {
//        persistence.remove(model);
//    }
//
//    public M find(Class<M> modelClass, int id) {
//        return persistence.find(modelClass, id);
//    }
//
    public List<M> findAll(Class<M> mClass) {
        return persistence.findAll(mClass);
    }

}
