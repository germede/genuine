package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.PersistenceService;

import java.util.List;

public class BookRepository extends AbstractCrudRepository<Book> {

    public BookRepository(PersistenceService persistence) {
        super(persistence);
    }

    public List<Book> findAll() {
        return persistence.query("SELECT s FROM Book s").getResultList();
    }

    public List<Book> findByTitle(String title) {
        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
            .setParameter("title", title)
            .getResultList();
    }


}
