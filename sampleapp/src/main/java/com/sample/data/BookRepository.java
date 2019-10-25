package com.sample.data;

import org.fluentness.base.persistence.Persistence;
import org.fluentness.data.CrudRepository;

import java.util.List;

public class BookRepository extends CrudRepository<Book> {


    public BookRepository(Persistence persistence) {
        super(persistence);
    }

    @Override
    public Class<Book> getModelClass() {
        return Book.class;
    }

    public List<Book> findByTitle(String title) {
        return persistence.query("SELECT s FROM Song s WHERE s.title = :title")
                .setParameter("title", title)
                .getResultList();
    }
}
