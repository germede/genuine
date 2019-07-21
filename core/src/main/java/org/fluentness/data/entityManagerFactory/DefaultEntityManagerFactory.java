package org.fluentness.data.entityManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class DefaultEntityManagerFactory implements EntityManagerFactory {

    @Override
    public EntityManager get(String persistenceUnit) throws PersistenceException {
        return Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
    }
}
