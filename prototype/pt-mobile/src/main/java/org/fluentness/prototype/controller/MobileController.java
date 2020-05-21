package org.fluentness.prototype.controller;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.prototype.view.MobileView;
import org.fluentness.service.log.Log;
import org.fluentness.view.component.Button;

import static org.fluentness.prototype.service.Localization._login;

public class MobileController extends AbstractMobileController<MobileView> {

    private final Log log;

    public MobileController(MobileView mobileView, Log log) {
        super(mobileView);
        this.log = log;
        mobileView.button1.onClick(this::changeText);
    }

    private void changeText(Button button) {
        button.setText(_login);
    }
}
