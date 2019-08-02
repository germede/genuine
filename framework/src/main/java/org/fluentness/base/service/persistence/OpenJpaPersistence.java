package org.fluentness.base.service.persistence;

import org.apache.openjpa.lib.log.LogFactory;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.base.service.configuration.ConfigurationService;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fluentness.base.service.configuration.ConfigurationService.PERSISTENCE_UNIT;

public class OpenJpaPersistence implements Persistence {
    
    private ConfigurationService configurationService;
    private Logger logger;
    
    private EntityManager entityManager;

    public OpenJpaPersistence(ConfigurationService configurationService, Logger logger)
            throws DefinitionException {
        
        this.configurationService = configurationService;
        this.logger = logger;
        init();
    }

    private void init() throws DefinitionException {
        Map<String, Object> properties = new HashMap<>();
        properties.put("openjpa.Log", (LogFactory) channel -> new OpenJpaLoggingBridge(logger));
        try {
            if (configurationService.has(ConfigurationService.PERSISTENCE_UNIT)) {
                this.entityManager = javax.persistence.Persistence
                    .createEntityManagerFactory(configurationService.get(PERSISTENCE_UNIT),properties)
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
    public boolean isTransactionActive() {
        return entityManager.getTransaction().isActive();
    }

    @Override
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    @Override
    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }

    @Override
    public boolean create(Model model) {
        if (!entityManager.contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            entityManager.persist(model);
            entityManager.flush();
            commitTransaction();
            logger.debug("%s record created successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record already exists, cannot create", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean update(Model model) {
        if (entityManager.contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            entityManager.persist(model);
            entityManager.flush();
            commitTransaction();
            logger.debug("%s record updated successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot update", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public boolean delete(Model model) {
        if (entityManager.contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            entityManager.remove(model);
            entityManager.flush();
            commitTransaction();
            logger.debug("%s record deleted successfully", model.getClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot delete", model.getClass().getSimpleName());
        return false;
    }

    @Override
    public <M extends Model> List<M> findAll(Class<M> modelClass) {
        Query query = entityManager.createQuery("SELECT e FROM " + modelClass.getSimpleName() + " e");
        logger.debug("Retrieving all %s records", modelClass.getSimpleName());
        return query.getResultList();
    }

    @Override
    public <M extends Model> M findById(Class<M> modelClass, int id) {
        logger.debug("Retrieving %s record by ID %s", modelClass.getSimpleName(), id);
        return entityManager.find(modelClass, id);
    }

}























