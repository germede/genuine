package com.sample.controller;

import org.fluentness.controller.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController<Desktop> {

    public DesktopController(Desktop desktop) {
        super(desktop);
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
