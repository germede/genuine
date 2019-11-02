package org.fluentness.service.persistence;

import org.fluentness.service.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface Persistence extends Service {

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
