package com.sample.controller;

import org.fluentness.controller.mobile.MobileView;
import org.fluentness.controller.mobile.template.MobileTemplate;

import static org.fluentness.controller.mobile.template.android.AndroidFactory.linearLayout;
import static org.fluentness.controller.mobile.template.android.AndroidFactory.text;

public class Mobile implements MobileView {

    @Override
    public MobileTemplate getTemplate() {
        return linearLayout(
            text("uno"),
            text("dos"),
            text("tres")
        );
    }
}