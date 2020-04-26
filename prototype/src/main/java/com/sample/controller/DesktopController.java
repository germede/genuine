package com.sample.controller;

import org.fluentness.controller.desktop.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    public DesktopController() {
        super(new DesktopView());
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
