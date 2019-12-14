package com.sample.repository;

import com.sample.model.BookModel;
import org.fluentness.repository.CrudRepository;
import org.fluentness.persistence.Persistence;

import java.util.List;

public class BookRepository extends CrudRepository<BookModel> {

    public BookRepository(Persistence persistence) {
        super(persistence);
    }

    public List<BookModel> findByTitle(String title) {
        List<BookModel> all = findAll(BookModel.class);
        return all;
//        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
//            .setParameter("title", title)
//            .getResultList();
    }


}
