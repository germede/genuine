package org.fluentness.base.service.entityManager;

import org.fluentness.base.service.Service;

import javax.persistence.EntityManager;

public interface EntityManagerService extends Service {

    @Override
    default int getDefinitionPriority() {
        return 600;
    }

    EntityManager em();
}
