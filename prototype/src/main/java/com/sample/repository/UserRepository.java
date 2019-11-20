package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.PersistenceService;

public class UserRepository extends AbstractCrudRepository<User> {

    public UserRepository(PersistenceService persistence) {
        super(persistence);
    }

}
