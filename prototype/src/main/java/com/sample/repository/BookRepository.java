package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public class BookRepository extends AbstractCrudRepository<Book> {

    public BookRepository(Persistence persistence) {
        super(persistence);
    }

    public List<Book> findByTitle(String title) {
        List<Book> all = findAll(Book.class);
        return all;
//        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
//            .setParameter("title", title)
//            .getResultList();
    }


}
