package com.sample.view;

import android.widget.TextView;
import org.fluentness.view.AbstractMobile;
import org.fluentness.view.MobileTemplate;

public class Mobile extends AbstractMobile {

    public TextView uno;
    public TextView dos;
    public TextView tres;

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