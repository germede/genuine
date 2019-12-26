package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends AbstractCrudRepository<Book> {

    protected UserRepository(Persistence persistence) {
        super(Book.class, persistence);
    }

}
