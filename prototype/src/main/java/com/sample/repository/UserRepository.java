package com.sample.repository;

import org.fluentness.repository.crud.Repository;
import org.fluentness.service.persistence.Persistence;

public class UserRepository extends Repository<Book> {

    protected UserRepository(Persistence persistence) {
        super(Book.class, persistence);
    }

}
