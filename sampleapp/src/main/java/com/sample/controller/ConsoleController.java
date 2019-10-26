package com.sample.controller;

import com.sample.repository.BookRepository;

public class ConsoleController extends org.fluentness.controller.console.ConsoleController {

    private BookRepository bookRepository;

    @ConsoleAction("Print all books containing name")
    public void printAllBooksContainingName(@Argument("name") String name) {
        bookRepository.findByTitle(name).stream().map(Object::toString).forEach(System.out::println);
    }
}