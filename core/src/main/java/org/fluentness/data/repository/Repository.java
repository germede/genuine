package org.fluentness.data.repository;

import org.fluentness.Fluentness;
import org.fluentness.base.service.logger.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface Repository<T extends org.fluentness.data.model.Repository> extends  {

    default Class<T> getModelClass() {
        String modelClassName = this.getClass().getCanonicalName().replace("Repository", "");
        try {
            return (Class<T>) Class.forName(modelClassName);
        } catch (ClassNotFoundException | ClassCastException e) {
            base(Logger.class).severe(
                "Model class %s not found for repository %s. Please respect the class naming conventions",
                this.getClass().getSimpleName().replace("Repository", ""),
                this.getClass().getSimpleName()
            );
        }
    }

    default EntityManager getEntityManager() {
        return Fluentness.getData().getEntityManager();
    }

    default boolean isTransactionActive() {
        return getEntityManager().getTransaction().isActive();
    }

    default void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    default void commitTransaction() {
        getEntityManager().getTransaction().commit();
    }

    default void rollbackTransaction() {
        getEntityManager().getTransaction().rollback();
    }

    default boolean create(T entity) {
        if (!getEntityManager().contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            getEntityManager().persist(entity);
            getEntityManager().flush();
            commitTransaction();
            base(Logger.class)
                .fine("%s record created successfully", getModelClass().getSimpleName());
            return true;
        }
        base(Logger.class)
            .fine("%s record already exists, cannot create", getModelClass().getSimpleName());
        return false;
    }

    default boolean update(T entity) {
        if (getEntityManager().contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            getEntityManager().persist(entity);
            getEntityManager().flush();
            commitTransaction();
            base(Logger.class).fine("%s record updated successfully", getModelClass().getSimpleName());
            return true;
        }
        base(Logger.class).fine("%s record doesn't exists, cannot update", getModelClass().getSimpleName());
        return false;
    }

    default boolean delete(T entity) {
        if (getEntityManager().contains(entity)) {
            if(!isTransactionActive()) {
                beginTransaction();
            }
            getEntityManager().remove(entity);
            getEntityManager().flush();
            commitTransaction();
            base(Logger.class).fine("%s record deleted successfully", getModelClass().getSimpleName());
            return true;
        }
        base(Logger.class).fine("%s record doesn't exists, cannot delete", getModelClass().getSimpleName());
        return false;
    }

    default List<T> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM " + getModelClass().getSimpleName() + " e");
        base(Logger.class).fine("Retrieving all %s records", getModelClass().getSimpleName());
        return query.getResultList();
    }

    default T findById(int id) {
        base(Logger.class).fine("Retrieving %s record by ID %s", getModelClass().getSimpleName(), id);
        return getEntityManager().find(getModelClass(), id);
    }

}
