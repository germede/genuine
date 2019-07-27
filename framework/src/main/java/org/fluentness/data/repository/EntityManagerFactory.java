package org.fluentness.data.repository;

import org.fluentness.base.BaseConsumer;
import org.fluentness.base.service.config.Config;
import org.fluentness.base.service.logger.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.fluentness.base.service.config.StringKey.PERSISTENCE_UNIT;

public enum EntityManagerFactory implements BaseConsumer {
    instance;

    private EntityManager entityManager;

    EntityManager em() {
        if (entityManager == null) {
            try {
                if (service(Config.class).has(PERSISTENCE_UNIT)) {
                    this.entityManager = Persistence
                        .createEntityManagerFactory(service(Config.class).get(PERSISTENCE_UNIT), System.getProperties())
                        .createEntityManager();
                } else {
                    throw new PersistenceException("No persistence unit defined in config environment");
                }
            } catch (PersistenceException e) {
                service(Logger.class).fatal(e);
            }
        }
        return entityManager;
    }
}
