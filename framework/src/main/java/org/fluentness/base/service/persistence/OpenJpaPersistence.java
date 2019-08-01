package org.fluentness.base.service.persistence;

import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.base.common.annotation.Inject;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.ConfigurationService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.configuration.ConfigurationService.PERSISTENCE_UNIT;

public class OpenJpaPersistence implements Persistence {

    @Inject
    ConfigurationService configuration;
    
    private final EntityManager entityManager;

    public OpenJpaPersistence() throws DefinitionException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("openjpa.Log", (LogFactory) channel -> new OpenJpaLoggingBridge());
        try {
            if (configuration.has(PERSISTENCE_UNIT)) {
                this.entityManager = javax.persistence.Persistence
                    .createEntityManagerFactory(configuration.get(PERSISTENCE_UNIT),properties)
                    .createEntityManager();
            } else {
                throw new PersistenceException("No persistence unit found on configuration service");
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
