package org.fluentness.data.repository;

import org.fluentness.Fluentness;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.data.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public interface Repository<T extends Model> {

    default Class<T> getModelClass() {
        String modelClassName = this.getClass().getCanonicalName().replace("Repository", "");
        try {
            return (Class<T>) Class.forName(modelClassName);
        } catch (ClassNotFoundException | ClassCastException e) {
            Fluentness.getBase().getService(Logger.class).severe(
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
            Fluentness.getBase().getLogger().fine("%s record created successfully", getModelClass().getSimpleName());
            return true;
        }
        Fluentness.getBase().getLogger().fine("%s record already exists, cannot create", getModelClass().getSimpleName());
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
            Fluentness.getBase().getLogger().fine("%s record updated successfully", getModelClass().getSimpleName());
            return true;
        }
        Fluentness.getBase().getLogger().fine("%s record doesn't exists, cannot update", getModelClass().getSimpleName());
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
            Fluentness.getBase().getLogger().fine("%s record deleted successfully", getModelClass().getSimpleName());
            return true;
        }
        Fluentness.getBase().getLogger().fine("%s record doesn't exists, cannot delete", getModelClass().getSimpleName());
        return false;
    }

    default List<T> findAll() {
        Query query = getEntityManager().createQuery("SELECT e FROM " + getModelClass().getSimpleName() + " e");
        Fluentness.getBase().getLogger().fine("Retrieving all %s records", getModelClass().getSimpleName());
        return query.getResultList();
    }

    default T findById(int id) {
        Fluentness.getBase().getLogger().fine("Retrieving %s record by ID %s", getModelClass().getSimpleName(), id);
        return getEntityManager().find(getModelClass(), id);
    }

}
