package org.fluentness.persistence;

import org.fluentness.model.Model;
import org.fluentness.configuration.Key;

import java.util.List;

public interface Persistence {

    Key<String> JDBC_URL = new Key<>();
    Key<String> USERNAME = new Key<>();
    Key<String> PASSWORD = new Key<>();

    <M extends Model> List<M> findAll(Class<M> model);

//    EntityManager getEntityManager();
//
//    <M extends Object> M find(Class<M> modelClass, int id);
//
//    Query query(String query);
//
//    boolean persist(Object model);
//
//    boolean remove(Object model);
//
//    boolean isActive();
//
//    void begin();
//
//    void commit();
//
//    void rollback();
}
