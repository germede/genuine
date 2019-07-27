package org.fluentness.data.repository;

import org.fluentness.base.BaseConsumer;
import org.fluentness.base.common.ArchitectureElement;
import org.fluentness.base.service.entityManager.EntityManagerService;
import org.fluentness.base.service.logger.LoggerService;
import org.fluentness.data.DataConsumer;
import org.fluentness.data.model.Model;

import javax.persistence.Query;
import java.util.List;

public interface Repository<M extends Model> extends ArchitectureElement, BaseConsumer, DataConsumer {

    @Override
    default int getDefinitionPriority() {
        return 1000;
    }

    default Class<M> getModelClass() {
        String modelClassName = this.getClass().getCanonicalName().replace("Repository", "");
        try {
            return (Class<M>) Class.forName(modelClassName);
        } catch (ClassNotFoundException | ClassCastException e) {
            consumeService(LoggerService.class).severe(
                "Model class %s not found for repository %s. Please respect the class naming conventions",
                this.getClass().getSimpleName().replace("Repository", ""),
                this.getClass().getSimpleName()
            );
        }
        return null;
    }
    
    default boolean isTransactionActive() {
        return consumeService(EntityManagerService.class).em().getTransaction().isActive();
    }

    default void beginTransaction() {
        consumeService(EntityManagerService.class).em().getTransaction().begin();
    }

    default void commitTransaction() {
        consumeService(EntityManagerService.class).em().getTransaction().commit();
    }

    default void rollbackTransaction() {
        consumeService(EntityManagerService.class).em().getTransaction().rollback();
    }

    default boolean create(M entity) {
        if (!consumeService(EntityManagerService.class).em().contains(entity)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            consumeService(EntityManagerService.class).em().persist(entity);
            consumeService(EntityManagerService.class).em().flush();
            commitTransaction();
            consumeService(LoggerService.class)
                .fine("%s record created successfully", getModelClass().getSimpleName());
            return true;
        }
        consumeService(LoggerService.class)
            .fine("%s record already exists, cannot create", getModelClass().getSimpleName());
        return false;
    }

    default boolean update(M entity) {
        if (consumeService(EntityManagerService.class).em().contains(entity)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            consumeService(EntityManagerService.class).em().persist(entity);
            consumeService(EntityManagerService.class).em().flush();
            commitTransaction();
            consumeService(LoggerService.class).fine("%s record updated successfully", getModelClass().getSimpleName());
            return true;
        }
        consumeService(LoggerService.class).fine("%s record doesn't exists, cannot update", getModelClass().getSimpleName());
        return false;
    }

    default boolean delete(M entity) {
        if (consumeService(EntityManagerService.class).em().contains(entity)) {
            if (!isTransactionActive()) {
                beginTransaction();
            }
            consumeService(EntityManagerService.class).em().remove(entity);
            consumeService(EntityManagerService.class).em().flush();
            commitTransaction();
            consumeService(LoggerService.class).fine("%s record deleted successfully", getModelClass().getSimpleName());
            return true;
        }
        consumeService(LoggerService.class).fine("%s record doesn't exists, cannot delete", getModelClass().getSimpleName());
        return false;
    }

    default List<M> findAll() {
        Query query = consumeService(EntityManagerService.class).em().createQuery("SELECT e FROM " + getModelClass().getSimpleName() + " e");
        consumeService(LoggerService.class).fine("Retrieving all %s records", getModelClass().getSimpleName());
        return query.getResultList();
    }

    default M findById(int id) {
        consumeService(LoggerService.class).fine("Retrieving %s record by ID %s", getModelClass().getSimpleName(), id);
        return consumeService(EntityManagerService.class).em().find(getModelClass(), id);
    }

}
