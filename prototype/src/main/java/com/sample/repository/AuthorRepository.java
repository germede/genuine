package com.sample.repository;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public class AuthorRepository extends AbstractCrudRepository<Author> {

    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }

    public List<Book> findByTitle(String title) {
        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
            .setParameter("title", title)
            .getResultList();
    }


}
