package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

public class AuthorRepository extends AbstractCrudRepository {

    protected AuthorRepository(Persistence persistence) {
        super(Author.class, persistence);
    }


}
