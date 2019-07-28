package org.fluentness.base.service.persistence;

import org.fluentness.base.common.annotation.DefinitionPriority;
import org.fluentness.base.service.Service;

import javax.persistence.EntityManager;

@DefinitionPriority(300)
public interface Persistence extends Service {

    EntityManager em();

}
