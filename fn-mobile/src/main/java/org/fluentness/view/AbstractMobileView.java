package org.fluentness.view;

import android.content.Context;
import android.view.View;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.container.AndroidLinearLayout;
import org.fluentness.view.component.layout.Layout;
import org.fluentness.view.component.table.AndroidTable;
import org.fluentness.view.component.text.AndroidButton;

public abstract class AbstractMobileView extends AbstractView<
    Component,
    Layout,
    AndroidButton,
    AndroidTable,
    AndroidLinearLayout
    >
{

    public static Context context;
    private final View androidView;

    public AbstractMobileView() {
        androidView = (View) structure();
    }

    public View getAndroidView() {
        return androidView;
    }

    @Override
    protected AndroidLinearLayout linearLayout(int orientation, Component... components) {
        return new AndroidLinearLayout(context, orientation, components);
    }

    @Override
    protected AndroidButton button(CharSequence text) {
        return new AndroidButton(context, text);
    }

    @Override
    protected AndroidTable table(CharSequence[] header, Object[]... rows) {
        return null;
    }
}
