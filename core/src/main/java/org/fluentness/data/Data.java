package org.fluentness.data;

import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;

import javax.persistence.EntityManager;
import java.util.Map;

public final class Data {

    private final Map<Class, Repository> repositories;
    private final EntityManager entityManager;

    Data(Map<Class, Repository> repositories, EntityManager entityManager) {
        this.repositories = repositories;
        this.entityManager = entityManager;
    }

    public <M extends Model> Repository<M> getRepository(Class<M> modelClass) {
        return (Repository<M>) repositories.get(modelClass);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
