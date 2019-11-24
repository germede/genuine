package org.fluentness.service.persistence;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Singleton
public interface Persistence extends Service {

    Key<String> persistence_unit = new Key<>();

    EntityManager getEntityManager();

    <M extends Object> M find(Class<M> modelClass, int id);

    Query query(String query);

    boolean persist(Object model);

    boolean remove(Object model);

    boolean isActive();

    void begin();

    void commit();

    void rollback();
}
