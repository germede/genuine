package com.sample.controller;

import android.view.View;
import com.sample.view.MobileView;
import org.fluentness.controller.AbstractMobileController;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class MobileController extends AbstractMobileController<MobileView> {

    private final Log log;

    public MobileController(MobileView mobileView, Log log, Persistence persistence) {
        super(mobileView);
        this.log = log;
        mobileView.uno.setOnClickListener(this::test);
    }

    public void test(View view) {
        log.error("TEST");
    }

}
