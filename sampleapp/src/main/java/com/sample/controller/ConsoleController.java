package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.console.AbstractConsoleController;

public class ConsoleController extends AbstractConsoleController {

    private BookRepository bookRepository;

    @Description("Print all books containing name")
    public void printAllBooksContainingName(@Argument("name") String name) {
        bookRepository.findByTitle(name).stream().map(Object::toString).forEach(System.out::println);
    }
}