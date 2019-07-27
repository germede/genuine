package org.fluentness.base.service.entityManager;

import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.config.ConfigService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import static org.fluentness.base.service.config.StringKey.PERSISTENCE_UNIT;

public class DefaultEntityManagerService implements EntityManagerService {

    private EntityManager entityManager;

    public DefaultEntityManagerService() throws DefinitionException {
        try {
            if (consumeService(ConfigService.class).has(PERSISTENCE_UNIT)) {
                String persistenceUnit = consumeService(ConfigService.class).get(PERSISTENCE_UNIT);
                this.entityManager = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
            } else {
                throw new PersistenceException("No persistence unit defined in config environment");
            }
        } catch (PersistenceException e) {
            throw new DefinitionException(e);
        }
    }

    @Override
    public EntityManager em() {
        return entityManager;
    }
}
