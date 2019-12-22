package com.sample.repository;

import com.sample.model.UserModel;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.repository.crud.AbstractCrudRepository;

public class UserRepository extends AbstractCrudRepository<UserModel> {

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

}
