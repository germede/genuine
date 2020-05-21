package org.fluentness.prototype.controller;

import org.fluentness.prototype.view.DesktopView;
import org.fluentness.controller.AbstractDesktopController;
import org.fluentness.view.component.Button;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    public DesktopController(DesktopView desktopView) {
        super(desktopView);
        desktopView.button1.onClick(this::onButtonClick);
    }

    private void onButtonClick(Button button) {
        System.out.println("TEST");
    }


}
