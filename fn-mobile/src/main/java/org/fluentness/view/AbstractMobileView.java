package org.fluentness.view;

import android.app.Activity;
import android.view.View;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.AndroidLinearLayout;
import org.fluentness.view.component.layout.AndroidTabLayout;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.AndroidButton;
import org.fluentness.view.component.text.Button;

public abstract class AbstractMobileView extends AbstractView {

    public static Activity context;
    private final View androidView;

    public AbstractMobileView() {
        androidView = (View) structure();
    }

    public View getAndroidView() {
        return androidView;
    }

    @Override
    protected LinearLayout linearLayout(int orientation, Component... components) {
        return new AndroidLinearLayout(orientation, components);
    }

    @Override
    protected Button button(CharSequence text) {
        return new AndroidButton(text);
    }

    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return null;
    }

    @Override
    protected TabLayout tabLayout(TabLayout.Tab... tabs) {
        return new AndroidTabLayout(tabs);
    }
}
