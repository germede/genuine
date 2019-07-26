package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.base.common.Architecture;
import org.fluentness.base.common.exception.DefinitionException;
import org.fluentness.data.model.Model;
import org.fluentness.data.repository.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.Modifier;

import static org.fluentness.base.common.environment.StringKey.PERSISTENCE_UNIT;

public class Data extends Architecture<Model, Repository> {

    private EntityManager entityManager;

    public Data(Fluentness app) {
        super(app);
        if (Fluentness.getEnvironment().has(PERSISTENCE_UNIT)) {
            String persistenceUnit = Fluentness.getEnvironment().get(PERSISTENCE_UNIT);
            this.entityManager = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    protected void validateDefinition(Class<Model> key, Class<Repository> value) throws DefinitionException {
        if (key.equals(Model.class)) {
            throw new DefinitionException("Model itself cannot be declared as a model");
        }
        if (defined.containsKey(key)) {
            throw new DefinitionException("Model class %s was already defined");
        }
        if (key.isInterface()) {
            throw new DefinitionException("Model class %s cannot be an interface");
        }
        if (!key.isAnnotationPresent(Entity.class)) {
            throw new DefinitionException("Model class %s must be annotated with Entity");
        }

        if (Modifier.isAbstract(value.getModifiers())) {
            throw new DefinitionException("Repository class %s cannot be an abstract class");
        }
    }

    public <M extends Model> ForModel<M> forModel(Class<M> serviceInterface) {

        return new ForModel<>(serviceInterface);
    }

    public final class ForModel<M extends Model> {

        private final Class<M> modelClass;

        private ForModel(Class<M> modelClass) {
            this.modelClass = modelClass;
        }

        public <R extends Repository<M>> Data useRepository(Class<R> repository) {
            defined.put((Class<Model>) modelClass, (Class<Repository>) repository);
            return Data.this;
        }
    }
}
