package com.sample.repository;

import org.fluentness.repository.CrudRepository;
import org.fluentness.persistence.Persistence;

public class AuthorRepository extends CrudRepository<Authors> {





    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }

}
