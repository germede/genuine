package com.sample.controller;

import com.sample.repository.AuthorRepository;
import org.fluentness.controller.desktop.Controller;
import javax.swing.event.CaretEvent;
import java.io.IOException;

public class DesktopController extends Controller<Desktop> {

    private final AuthorRepository authorRepository;

    public DesktopController(AuthorRepository authorRepository)  {
        this.authorRepository = authorRepository;
    }

    @Action(selector = ".button", event = Event.CLICK)
    void test(CaretEvent caretEvent) {
        System.out.println("test");
        new DesktopController(null).test(1234);
    }


    boolean test = new Boolean(true);

    @Override
    protected Desktop getNewDesktop() {
        return new Desktop();
    }
}
