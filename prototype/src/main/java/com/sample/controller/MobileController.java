package com.sample.controller;

import android.view.View;
import com.sample.view.Mobile;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class MobileController extends AbstractMobileController<Mobile> {

    private final Log log;

    public MobileController(Mobile mobile, Log log, Persistence persistence) {
        super(mobile);
        this.log = log;
        mobile.uno.setOnClickListener(this::test);
    }

    public void test(View view) {
        log.error("TEST");
    }

}
