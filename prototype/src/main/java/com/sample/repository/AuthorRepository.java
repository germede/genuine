package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.PersistenceService;

import java.util.List;

public class AuthorRepository extends AbstractCrudRepository<Author> {

    public AuthorRepository(PersistenceService persistence) {
        super(persistence);
    }

    public List<Book> findByTitle(String title) {
        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
            .setParameter("title", title)
            .getResultList();
    }


}
