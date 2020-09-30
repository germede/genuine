package org.fluentness.prototype;

import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;

public class MobileController extends AbstractMobileController<MobileView> {

    public MobileController(MobileView view, Log log) {
        super(view);
        onClick(view.button1, this::changeText);
    }

    private void changeText() {
//        view.button1.setText(_login);
    }
}
