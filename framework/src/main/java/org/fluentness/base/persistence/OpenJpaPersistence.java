package org.fluentness.base.persistence;

import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.base.configuration.Configuration;
import org.fluentness.base.logger.Logger;
import org.fluentness.data.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;

public class OpenJpaPersistence implements Persistence {


    private final Logger logger;

    private EntityManager entityManager;

    public OpenJpaPersistence(Configuration configuration, Logger logger) throws DefinitionException {

        this.logger = logger;

        Map<String, Object> properties = new HashMap<>();
        properties.put("openjpa.log", (LogFactory) channel -> new OpenJpaLoggingBridge(logger));

        try {
            if (configuration.has("persistence_unit")) {
                this.entityManager = javax.persistence.Persistence
                        .createEntityManagerFactory(configuration.get("persistence_unit"), properties)
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
            logger.debug("%s record created successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
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
            logger.debug("%s record deleted successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public <M extends Model> M find(Class<M> modelClass, int id) {
        logger.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
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























