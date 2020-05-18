package com.sample.controller;

import android.graphics.Color;
import android.widget.TextView;
import org.fluentness.controller.AbstractMobile;
import org.fluentness.controller.MobileView;

public class Mobile extends AbstractMobile {

    private TextView uno;
    private TextView dos;
    private TextView tres;

    @Override
    public MobileView render() {
        return activity(
            linearLayout(
                uno = text("uno"),
                dos = text("dos"),
                tres = text("tres"),
                calendar()
            )
        );
    }

    @Override
    public void style() {
        uno.setTextColor(Color.RED);
    }
}