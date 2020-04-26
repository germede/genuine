package com.sample.repository;

import org.fluentness.repository.crud.AbstractRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(Persistence persistence, Log log) {
        super(persistence, log, User.class);
    }
}
