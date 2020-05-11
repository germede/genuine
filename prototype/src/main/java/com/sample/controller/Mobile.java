package com.sample.controller;

import org.fluentness.controller.AbstractMobile;

public class Mobile extends AbstractMobile {

    public Mobile() {
        super(
            linearLayout(
                text("uno"),
                text("dos"),
                text("tres")
            )
        );
    }
}