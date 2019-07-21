package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.data.entityManagerFactory.DefaultEntityManagerFactory;
import org.fluentness.data.entityManagerFactory.EntityManagerFactory;

import javax.persistence.EntityManager;

import static org.fluentness.base.config.StringKey.PERSISTENCE_UNIT;

public class Data {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void initialize() {
        if (entityManagerFactory == null) {
            entityManagerFactory = new DefaultEntityManagerFactory();
        }

        if (Fluentness.base.getConfig().has(PERSISTENCE_UNIT)) {
            this.entityManager = entityManagerFactory.get(Fluentness.base.getConfig().get(PERSISTENCE_UNIT));
        }
    }

    public void reset() {
        entityManagerFactory = null;
        entityManager = null;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
