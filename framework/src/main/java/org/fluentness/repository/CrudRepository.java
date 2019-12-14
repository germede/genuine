package org.fluentness.repository;

import org.fluentness.injector.FnInjector;
import org.fluentness.model.Model;
import org.fluentness.persistence.Persistence;

import java.util.List;

public abstract class CrudRepository<M extends Model> {
    protected Persistence persistence = FnInjector.;

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
