package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

public class BookRepository extends AbstractCrudRepository<Book> {

    protected BookRepository(Persistence persistence) {
        super(Book.class, persistence);
    }

}
