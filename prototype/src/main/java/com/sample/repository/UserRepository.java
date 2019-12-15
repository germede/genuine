package com.sample.repository;

import com.sample.model.UserModel;
import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.persistence.Persistence;

public class UserRepository extends AbstractCrudRepository<UserModel> {

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

}
