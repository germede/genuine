package com.sample.repository;

import com.sample.model.UserModel;
import org.fluentness.persistence.Persistence;
import org.fluentness.repository.AbstractRepository;

public class UserRepository extends AbstractRepository<UserModel> {

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

}
