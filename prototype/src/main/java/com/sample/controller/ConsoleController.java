package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.console.AbstractConsoleController;

public class ConsoleController extends AbstractConsoleController {

    private BookRepository bookRepository;

    public ConsoleController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Action(description = "Print all books containing name", category = "library")
    public void search_books(String name, int limit) {
        bookRepository.findByTitle(name).stream().map(Object::toString).forEach(System.out::println);
    }
}