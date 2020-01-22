package com.sample.controller;

import com.sample.repository.AuthorRepository;
import org.fluentness.controller.desktop.Controller;

public class DesktopController extends Controller<Desktop> {

    private final AuthorRepository authorRepository;

    public DesktopController(AuthorRepository authorRepository)  {
        this.authorRepository = authorRepository;
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
