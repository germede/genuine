package com.sample.controller;

import com.sample.repository.BookRepository;

public class ConsoleController extends org.fluentness.controller.console.ConsoleController {

    private BookRepository bookRepository;

    public ConsoleController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Action(description = "Print all books containing name", category = "library")
    public void search_books(String name, int limit) {
        bookRepository.findByTitle(name).stream().map(Object::toString).forEach(System.out::println);
    }
}