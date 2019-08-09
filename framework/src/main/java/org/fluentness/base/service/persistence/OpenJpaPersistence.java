package org.fluentness.base.service.persistence;

import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.base.service.configuration.ConfigurationService;
import org.fluentness.base.service.logger.LoggerService;
import org.fluentness.data.model.Model;
import org.fluentness.base.common.exception.DefinitionException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.service.configuration.FluentnessSettings.PERSISTENCE_UNIT;

public class OpenJpaPersistence implements Persistence {


    private final LoggerService loggerService;
    
    private EntityManager entityManager;

    public OpenJpaPersistence(ConfigurationService configurationService, LoggerService loggerService) throws DefinitionException {

        this.loggerService = loggerService;
        
        Map<String, Object> properties = new HashMap<>();
        properties.put("openjpa.Log", (LogFactory) channel -> new OpenJpaLoggingBridge(loggerService));

        try {
            if (configurationService.contains(PERSISTENCE_UNIT)) {
                this.entityManager = javax.persistence.Persistence
                        .createEntityManagerFactory(configurationService.get(PERSISTENCE_UNIT), properties)
                        .createEntityManager();
            }
        } catch (PersistenceException e) {
            throw new DefinitionException(e);
        }
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean persist(Model model) {
        if (!entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.persist(model);
            entityManager.flush();
            commit();
            loggerService.debug("%s record created successfully", model.getClass().getSimpleName());
            return true;
        }
        loggerService.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean remove(Model model) {
        if (entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.remove(model);
            entityManager.flush();
            commit();
            loggerService.debug("%s record deleted successfully", model.getClass().getSimpleName());
            return true;
        }
        loggerService.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public <M extends Model> M find(Class<M> modelClass, int id) {
        loggerService.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
        return null;
    }

    @Override
    public Query rawQuery(String query) {
        loggerService.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
        return null;
    }

    @Override
    public boolean isActive() {
        return entityManager.getTransaction().isActive();
    }

    @Override
    public void begin() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollback() {
        entityManager.getTransaction().rollback();
    }

}























