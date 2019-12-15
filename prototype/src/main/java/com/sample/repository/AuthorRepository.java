package com.sample.repository;

import com.sample.model.AuthorModel;
import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.persistence.Persistence;

public class AuthorRepository extends AbstractCrudRepository<AuthorModel> {

    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }

}
