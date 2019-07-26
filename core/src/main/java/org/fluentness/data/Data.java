package org.fluentness.data;

import org.fluentness.base.common.Architecture;
import org.fluentness.data.model.Repository;

import java.util.Map;

public class Data extends Architecture<Repository> {

    private static Data instance;
//    private EntityManager entityManager;

    Data(Map<Class<Repository>, Repository> applied) {
        super(applied);
        instance = this;
//        if (Fluentness.getEnvironment().has(PERSISTENCE_UNIT)) {
//            String persistenceUnit = Fluentness.getEnvironment().get(PERSISTENCE_UNIT);
//            this.entityManager = Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
//        }
    }

//    public EntityManager getEntityManager() {
//        return entityManager;
//    }

    public interface Consumer {
        static <R extends Repository> R data(Class<R> repository) {
            return (R) instance.instances.get(repository);
        }
    }
}
