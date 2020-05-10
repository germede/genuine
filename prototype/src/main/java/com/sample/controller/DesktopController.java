package com.sample.controller;

import com.sample.view.DesktopView;
import org.fluentness.controller.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    public DesktopController(DesktopView desktopView) {
        super(desktopView);
    }

    @Action(selector = "#daButton", event = Event.CLICK)
    void test() {
        System.out.println("test");
    }

}
