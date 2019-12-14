package com.sample.repository;

import com.sample.model.UserModel;
import org.fluentness.repository.CrudRepository;
import org.fluentness.persistence.Persistence;

public class UserRepository extends CrudRepository<UserModel> {

    public UserRepository(Persistence persistence) {
        super(persistence);
    }

}
