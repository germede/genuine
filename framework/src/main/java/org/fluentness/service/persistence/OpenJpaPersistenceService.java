package org.fluentness.service.persistence;

import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logging.LoggingService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.service.configuration.ConfigurationService.persistence_unit;

public class OpenJpaPersistenceService implements PersistenceService {

    private final LoggingService loggingService;
    protected EntityManager entityManager;

    public OpenJpaPersistenceService(ConfigurationService configuration, LoggingService loggingService) {
        this.loggingService = loggingService;
        if (configuration.has(persistence_unit)) {
            Map<String, Object> properties = new HashMap<>();
            // redirect OpenJPA log to Fluentness log
            properties.put("openjpa.Log", new OpenJpaLoggingBridge(loggingService));
            this.entityManager = javax.persistence.Persistence
                .createEntityManagerFactory(configuration.get(persistence_unit), properties)
                .createEntityManager();
        }

    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public boolean persist(Object model) {
        if (!entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.persist(model);
            entityManager.flush();
            commit();
            loggingService.debug("%s record created successfully", model.getClass().getSimpleName());
            return true;
        }
        loggingService.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean remove(Object model) {
        if (entityManager.contains(model)) {
            if (!isActive()) {
                begin();
            }
            entityManager.remove(model);
            entityManager.flush();
            commit();
            loggingService.debug("%s record deleted successfully", model.getClass().getSimpleName());
            return true;
        }
        loggingService.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public <M> M find(Class<M> modelClass, int id) {
        loggingService.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
        return entityManager.find(modelClass, id);
    }

    @Override
    public Query query(String query) {
        return entityManager.createQuery(query);
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























