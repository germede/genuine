package org.fluentness.data.entityManagerFactory;

import javax.persistence.EntityManager;

public interface EntityManagerFactory {

    EntityManager get(String persistenceUnit);

}
