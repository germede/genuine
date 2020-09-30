package org.fluentness.prototype.user;

import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class UserRepository extends AbstractCrudRepository<User> {

    public UserRepository(Persistence persistence, Log log) throws SQLException {
        super(persistence, log, User.class);
    }
}
