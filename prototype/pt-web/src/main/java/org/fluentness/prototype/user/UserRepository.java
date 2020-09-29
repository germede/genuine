package org.fluentness.prototype.user;

import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class UserRepository extends AbstractCrudRepository<User> {

    public UserRepository(Persistence persistence) throws SQLException {
        super(persistence, User.class);
    }
}
