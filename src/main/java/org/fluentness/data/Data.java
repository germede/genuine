package org.fluentness.data;

import org.fluentness.base.settings.Settings;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.fluentness.base.settings.StringKey.PERSISTENCE_UNIT;

public enum Data {
    call;

    private EntityManager entityManager;

    public void initialize(String appPackage) {
        entityManager = Persistence
            .createEntityManagerFactory(Settings.call.getString(PERSISTENCE_UNIT))
            .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
