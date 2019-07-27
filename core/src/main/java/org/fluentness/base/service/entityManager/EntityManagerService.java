package org.fluentness.base.service.entityManager;

import org.fluentness.base.service.Service;

public interface EntityManagerService extends Service {

    @Override
    default int getDefinitionPriority() {
        return 600;
    }

    javax.persistence.EntityManager em();
}
