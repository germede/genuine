package org.fluentness.prototype.repository;

import org.fluentness.prototype.model.User;
import org.fluentness.repository.CrudRepository;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends CrudRepository<User> {

    public UserRepository(Persistence persistence) {
        super(User.class, persistence);
    }
}
