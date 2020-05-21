package com.sample.controller;

import com.sample.view.DesktopView;
import org.fluentness.controller.AbstractDesktopController;

public class DesktopDesktopController extends AbstractDesktopController<DesktopView> {

    public DesktopDesktopController(DesktopView desktopView) {
        super(desktopView);
        onClick(desktopView.button1,this::onButtonClick);
    }

    private void onButtonClick() {
        System.out.println("TEST");
    }

}
