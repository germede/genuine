package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import static org.fluentness.base.common.environment.StringKey.PERSISTENCE_UNIT;

public final class DataDefinition {

    private EntityManager entityManager;
    private Map<Class, Repository> repositories = new HashMap();

    public <M extends Model> ForModel<M> forModel(Class<M> modelClass) throws DefinitionException {

        if (modelClass.equals(Model.class)) {
            throw new DefinitionException("The interface Model itself cannot be declared as a model");
        }
        if (repositories.containsKey(modelClass)) {
            throw new DefinitionException("Model class %s was already defined");
        }
        if (modelClass.isInterface()) {
            throw new DefinitionException("Model class %s cannot be an interface");
        }
        if (Modifier.isAbstract(modelClass.getModifiers())) {
            throw new DefinitionException("Model class %s cannot be an abstract class");
        }
        if (!modelClass.isAnnotationPresent(Entity.class)) {
            throw new DefinitionException("Model class %s must be annotated with Entity");
        }

        return new ForModel<>(modelClass, this);
    }

    public DataDefinition useCustomEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
        return this;
    }

    public Data build() throws DefinitionException {

        // use default entity manager when none was set
        if (entityManager == null) {
            if (Fluentness.getEnvironment().has(PERSISTENCE_UNIT)) {
                try {
                    String persistenceUnit = Fluentness.getEnvironment().get(PERSISTENCE_UNIT);
                    entityManager = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
                } catch (PersistenceException e) {
                    throw new DefinitionException(e);
                }
            }
        }

        return new Data(repositories,entityManager);
    }

    public static final class ForModel<M extends Model> {

        private final Class<M> modelClass;
        private final DataDefinition builder;

        private ForModel(Class<M> modelClass, DataDefinition builder) {
            this.modelClass = modelClass;
            this.builder = builder;
        }

        public DataDefinition useRepository(Repository<M> repository) {
            builder.repositories.put(modelClass, repository);
            Fluentness.addOnionLayer(repository.getClass());
            return builder;
        }
    }
}
