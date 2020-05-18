package com.sample.controller;

import android.widget.TextView;
import org.fluentness.controller.AbstractMobile;
import org.fluentness.controller.MobileTemplate;

public class Mobile extends AbstractMobile {

    TextView uno;
    TextView dos;
    TextView tres;

    @Override
    public MobileTemplate getTemplate() {
        return activity(
            linearLayout(
                uno = text("uno"),
                dos = text("dos"),
                tres = text("tres")
            )
        );
    }
}