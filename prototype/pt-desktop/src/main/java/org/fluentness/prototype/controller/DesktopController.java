package org.fluentness.prototype.controller;

import org.fluentness.prototype.view.DesktopView;
import org.fluentness.controller.AbstractDesktopController;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    public DesktopController(DesktopView desktopView) {
        super(desktopView);
        onClick(desktopView.button1,this::onButtonClick);
    }

    private void onButtonClick() {
        System.out.println("TEST");
    }

}
