package com.sample.controller;

import org.fluentness.controller.AbstractDesktopController;

import java.lang.annotation.*;

public class DesktopController extends AbstractDesktopController<Desktop> {

    public DesktopController(Desktop desktop) {
        super(desktop);
    }

    void test() {
        System.out.println("test");
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Action {

    }
}
