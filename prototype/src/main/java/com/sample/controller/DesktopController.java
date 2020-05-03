package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController {

    public DesktopController() {
        super(Desktop.class);
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
