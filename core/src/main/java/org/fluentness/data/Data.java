package org.fluentness.data;

import org.fluentness.Fluentness;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.fluentness.base.config.StringKey.PERSISTENCE_UNIT;

public class Data {

    private EntityManager entityManager;

    public void initialize() {
        if (Fluentness.base.getConfig().has(PERSISTENCE_UNIT)) {
            entityManager = Persistence
                .createEntityManagerFactory(Fluentness.base.getConfig().get(PERSISTENCE_UNIT))
                .createEntityManager();
        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
