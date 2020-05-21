package com.sample.view;

import android.widget.TextView;
import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.template.Template;

public class MobileView extends AbstractMobileView {

    public TextView uno;
    public TextView dos;
    public TextView tres;

    @Override
    protected Template template() {
        return activity(
            linearLayout(
                uno = text("uno"),
                dos = text("dos"),
                tres = text("tres")
            )
        );
    }

    @Override
    protected void style() {

    }
}