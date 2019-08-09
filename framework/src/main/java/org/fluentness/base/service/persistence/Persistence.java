package org.fluentness.base.service.persistence;

import org.fluentness.base.service.Service;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public interface Persistence extends Service {

    EntityManager getEntityManager();

    <M extends Model> M find(Class<M> modelClass, int id);

    Query rawQuery(String query);

    boolean persist(Model model);

    boolean remove(Model model);

    boolean isActive();

    void begin();

    void commit();

    void rollback();
}
