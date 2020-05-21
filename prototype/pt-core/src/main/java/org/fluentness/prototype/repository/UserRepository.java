package org.fluentness.prototype.repository;

import org.fluentness.prototype.model.User;
import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends AbstractCrudRepository<User> {

    public UserRepository(Persistence persistence, Log log) {
        super(persistence, log, User.class);
    }
}
