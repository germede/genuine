package com.sample.controller;

import org.fluentness.controller.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController<Desktop> {

    public DesktopController(Desktop desktop) {
        super(desktop);
    }

    void test() {
        System.out.println("test");
    }

}
