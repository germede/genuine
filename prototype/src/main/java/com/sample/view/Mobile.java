package com.sample.view;

import org.fluentness.view.MobileView;
import org.fluentness.view.MobileTemplate;

import static org.fluentness.view.AndroidFactory.linearLayout;
import static org.fluentness.view.AndroidFactory.text;

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