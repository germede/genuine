package org.fluentness.data;

import org.fluentness.base.settings.Settings;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.fluentness.base.settings.StringKey.PERSISTENCE_UNIT;

public enum Data {
    instance;

    private EntityManager entityManager;

    public void initialize() {
        entityManager = Persistence
            .createEntityManagerFactory(Settings.instance.get(PERSISTENCE_UNIT))
            .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
