package org.fluentness.service.persistence;

import org.fluentness.repository.Model;
import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

import java.util.List;

@Singleton
public interface Persistence extends Service {

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
