package com.sample.repository;

import com.sample.controller.WebController;
import org.fluentness.service.persistence.Persistence;

import java.util.List;

public class AuthorRepository extends WebController {

    public AuthorRepository(Persistence persistence) {
        super(persistence);
    }

    public List<Book> findByTitle(String title) {
        return persistence.query("SELECT s FROM Book s WHERE s.title = :title")
            .setParameter("title", title)
            .getResultList();
    }


}
