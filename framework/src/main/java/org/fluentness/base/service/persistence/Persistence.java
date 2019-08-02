package org.fluentness.base.service.persistence;

import org.fluentness.base.service.Service;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import java.util.List;

public interface Persistence extends Service {

    EntityManager getEntityManager();

    boolean isTransactionActive();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    boolean create(Model model);

    boolean update(Model model);

    boolean delete(Model model);

    <M extends Model> List<M> findAll(Class<M> modelClass);

    <M extends Model> M findById(Class<M> modelClass, int id);
}
