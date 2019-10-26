package com.sample.repository;

import org.fluentness.service.persistence.PersistenceService;
import org.fluentness.repository.crud.CrudRepository;

import java.util.List;

public class BookRepository extends CrudRepository<Book> {

    public BookRepository(PersistenceService persistenceService) {
        super(persistenceService);
    }

    @Override
    public Class<Book> getModelClass() {
        return Book.class;
    }

    public List<Book> findByTitle(String title) {
        return persistenceService.query("SELECT s FROM Song s WHERE s.title = :title")
                .setParameter("title", title)
                .getResultList();
    }
}
