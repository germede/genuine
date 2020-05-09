package com.sample.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.MobileTemplate;

import static org.fluentness.view.AndroidFactory.linearLayout;
import static org.fluentness.view.AndroidFactory.text;

public class MobileView extends AbstractMobileView {

    @Override
    public MobileTemplate getTemplate() {
        return linearLayout(
            text("uno"),
            text("dos"),
            text("tres")
        );
    }
}