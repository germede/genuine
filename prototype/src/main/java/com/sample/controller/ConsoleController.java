package com.sample.controller;

import com.sample.model.Book;
import org.fluentness.controller.console.AbstractConsoleController;
import org.fluentness.persistence.Persistence;

public class ConsoleController extends AbstractConsoleController {

    private final Persistence persistence;

    public ConsoleController(Persistence persistence) {
        this.persistence = persistence;
    }

    @Action(description = "Print all books containing name", category = "library")
    public void search_books(String name, int limit) {
        persistence.select(Book.byName, name).stream().map(Object::toString).forEach(System.out::println);
    }
}