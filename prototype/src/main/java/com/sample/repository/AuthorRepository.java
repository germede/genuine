package com.sample.repository;

import org.fluentness.repository.crud.Repository;
import org.fluentness.service.persistence.Persistence;

public class AuthorRepository extends Repository<Author> {

    protected AuthorRepository(Persistence persistence) {
        super(Author.class, persistence);
    }


}
