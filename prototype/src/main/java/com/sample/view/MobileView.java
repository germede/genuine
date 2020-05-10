package com.sample.view;

import org.fluentness.view.AbstractMobileView;

public class MobileView extends AbstractMobileView {

    public MobileView() {
        super(
            linearLayout(
                text("uno"),
                text("dos"),
                text("tres")
            )
        );
    }
}