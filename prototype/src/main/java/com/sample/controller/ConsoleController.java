package com.sample.controller;

import com.sample.repository.Book;
import org.fluentness.controller.console.Controller;
import org.fluentness.service.persistence.Persistence;

public class ConsoleController extends Controller {

    private final Persistence persistence;

    public ConsoleController(Persistence persistence) {
        this.persistence = persistence;
    }

    @Action(description = "Print all books containing name", category = "library")
    public void search_books(String name, int limit) {
        persistence.select(Book.byName, name).stream().map(Object::toString).forEach(System.out::println);
    }
}