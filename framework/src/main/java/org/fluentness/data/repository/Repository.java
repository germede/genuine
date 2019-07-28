package org.fluentness.data.repository;

import org.fluentness.base.Base;
import org.fluentness.base.service.persistence.Persistence;
import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.common.lambda.KeyValuePair;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.data.Data;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@DefinitionPriority(1000)
public interface Repository<M extends Model> extends Base.Consumer, Data.Consumer {

    default Class<M> getModelClass() {
        String modelClassName = this.getClass().getCanonicalName().replace("Repository", "");
        try {
            return (Class<M>) Class.forName(modelClassName);
        } catch (ClassNotFoundException | ClassCastException e) {
            service(Logger.class).error(
                "Model class %s not found for repository %s. Please respect the class naming conventions",
                this.getClass().getSimpleName().replace("Repository", ""),
                this.getClass().getSimpleName()
            );
        }
        return null;
    }

    default EntityManager em() {
        return service(Persistence.class).em();
    }

    default boolean isTransactionActive() {
        return em().getTransaction().isActive();
    }

    default void beginTransaction() {
        em().getTransaction().begin();
    }

    default void commitTransaction() {
        em().getTransaction().commit();
    }

    default void rollbackTransaction() {
        em().getTransaction().rollback();
    }

    default boolean create(M model) {
        if (!em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().persist(model);
            em().flush();
            commitTransaction();
            service(Logger.class)
                .debug("%s record created successfully", getModelClass().getSimpleName());
            return true;
        }
        service(Logger.class)
            .debug("%s record already exists, cannot create", getModelClass().getSimpleName());
        return false;
    }

    default boolean update(M model) {
        if (em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().persist(model);
            em().flush();
            commitTransaction();
            service(Logger.class).debug("%s record updated successfully", getModelClass().getSimpleName());
            return true;
        }
        service(Logger.class).debug("%s record doesn't exists, cannot update", getModelClass().getSimpleName());
        return false;
    }

    default boolean delete(M model) {
        if (em().contains(model)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            em().remove(model);
            em().flush();
            commitTransaction();
            service(Logger.class).debug("%s record deleted successfully", getModelClass().getSimpleName());
            return true;
        }
        service(Logger.class).debug("%s record doesn't exists, cannot delete", getModelClass().getSimpleName());
        return false;
    }

    default List<M> findAll() {
        EntityManager em = em();
        Query query = em.createQuery("SELECT e FROM " + getModelClass().getSimpleName() + " e");
        service(Logger.class).debug("Retrieving all %s records", getModelClass().getSimpleName());
        return query.getResultList();
    }

    default M findById(int id) {
        service(Logger.class).debug("Retrieving %s record by ID %s", getModelClass().getSimpleName(), id);
        return
            em().find(getModelClass(), id);
    }

    default Query parametrizedQuery(Query query, KeyValuePair<Object>... parameters) {
        Arrays.stream(parameters).forEach(
            parameter -> query.setParameter(parameter.getKey(), parameter.getValue())
        );
        return query;
    }

}
