package org.fluentness.base;

import org.fluentness.base.service.configuration.Configuration;
import org.fluentness.base.service.logger.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.fluentness.base.service.configuration.Key.String.PERSISTENCE_UNIT;

public enum EntityManagerFactory implements Base.Consumer {
    instance;

    private EntityManager entityManager;

    public EntityManager em() {
        if (entityManager == null) {
            try {
                if (service(Configuration.class).has(PERSISTENCE_UNIT)) {
                    this.entityManager = Persistence
                        .createEntityManagerFactory(service(Configuration.class).get(PERSISTENCE_UNIT), System.getProperties())
                        .createEntityManager();
                } else {
                    throw new PersistenceException("No persistence unit defined in config environment");
                }
            } catch (PersistenceException e) {
                service(Logger.class).error(e);
            }
        }
        return entityManager;
    }
}
