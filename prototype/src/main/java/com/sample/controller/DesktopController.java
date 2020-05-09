package com.sample.controller;

import com.sample.view.Desktop;
import org.fluentness.controller.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController {

    public DesktopController() {
        super(Desktop.class);
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
