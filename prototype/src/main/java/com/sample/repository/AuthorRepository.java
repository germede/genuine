package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

public class AuthorRepository extends AbstractCrudRepository<Author> {

    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }



}
