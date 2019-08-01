package org.fluentness.data.repository;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.common.lambda.KeyValuePairLambda;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.persistence.Persistence;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@DefinitionPriority(1000)
public abstract class Repository<M extends Model> {

    Persistence persistence;
    Logger logger;

    public Repository(Persistence persistence, Logger logger) {
        this.persistence = persistence;
        this.logger = logger;
    }

    protected Class<M> getModelClass() {
        String modelClassName = this.getClass().getCanonicalName().replace("Repository", "");
        try {
            return (Class<M>) Class.forName(modelClassName);
        } catch (ClassNotFoundException | ClassCastException e) {
            logger.error(
                "Model class %s not found for repository %s. Please respect the class naming conventions",
                this.getClass().getSimpleName().replace("Repository", ""),
                this.getClass().getSimpleName()
            );
        }
        return null;
    }

    protected EntityManager em() {
        return persistence.em();
    }

    protected boolean isTransactionActive() {
        return em().getTransaction().isActive();
    }

    protected void beginTransaction() {
        em().getTransaction().begin();
    }

    protected void commitTransaction() {
        em().getTransaction().commit();
    }

    protected void rollbackTransaction() {
        em().getTransaction().rollback();
    }

    public boolean create(M model) {
        if (!em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().persist(model);
            em().flush();
            commitTransaction();
            logger.debug("%s record created successfully", getModelClass().getSimpleName());
            return true;
        }
        logger.debug("%s record already exists, cannot create", getModelClass().getSimpleName());
        return false;
    }

    public boolean update(M model) {
        if (em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().persist(model);
            em().flush();
            commitTransaction();
            logger.debug("%s record updated successfully", getModelClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot update", getModelClass().getSimpleName());
        return false;
    }

    public boolean delete(M model) {
        if (em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().remove(model);
            em().flush();
            commitTransaction();
            logger.debug("%s record deleted successfully", getModelClass().getSimpleName());
            return true;
        }
        logger.debug("%s record doesn't exists, cannot delete", getModelClass().getSimpleName());
        return false;
    }

    public List<M> findAll() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT e FROM " + getModelClass().getSimpleName() + " e");
        logger.debug("Retrieving all %s records", getModelClass().getSimpleName());
        return query.getResultList();
    }

    public M findById(int id) {
        logger.debug("Retrieving %s record by ID %s", getModelClass().getSimpleName(), id);
        return
            em().find(getModelClass(), id);
    }

    protected Query parametrizedQuery(Query query, KeyValuePairLambda<Object>... parameters) {
        Arrays.stream(parameters).forEach(
            parameter -> query.setParameter(parameter.getKey(), parameter.getValue())
        );
        return query;
    }

}
