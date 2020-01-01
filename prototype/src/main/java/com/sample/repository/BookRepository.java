package com.sample.repository;

import org.fluentness.repository.crud.Repository;
import org.fluentness.service.persistence.Persistence;

public class BookRepository extends Repository<Book> {

    protected BookRepository(Persistence persistence) {
        super(Book.class, persistence);
    }

}
