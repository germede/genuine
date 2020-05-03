package com.sample.controller;

import org.fluentness.controller.MobileView;
import org.fluentness.controller.MobileTemplate;

import static org.fluentness.controller.android.AndroidFactory.linearLayout;
import static org.fluentness.controller.android.AndroidFactory.text;

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