package com.sample.controller;

import com.sample.repository.BookRepository;
import org.fluentness.controller.console.Controller;

import java.util.stream.Collectors;

public class ConsoleController extends Controller {

    private final BookRepository bookRepository;

    public ConsoleController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Action(description = "Print all books containing name", category = "library")
    String search_books(String name, int limit) {
        return bookRepository.selectByField("name", name).stream()
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
    }
}