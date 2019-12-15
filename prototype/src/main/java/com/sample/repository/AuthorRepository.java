package com.sample.repository;

import com.sample.model.AuthorModel;
import org.fluentness.repository.AbstractRepository;
import org.fluentness.persistence.Persistence;

public class AuthorRepository extends AbstractRepository<AuthorModel> {

    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }

}
