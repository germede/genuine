package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends AbstractCrudRepository<User> {

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

}
