package org.fluentness.view;

import android.content.Context;
import android.view.View;
import org.fluentness.view.component.AndroidButton;
import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.AndroidLinearLayout;
import org.fluentness.view.container.LinearLayout;

public abstract class AbstractMobileView extends AbstractView {

    public static Context context;
    private final View androidView;

    public AbstractMobileView() {
        androidView = (View) structure();
    }

    public View getAndroidView() {
        return androidView;
    }

    @Override
    protected LinearLayout linearLayout(int orientation, Component... components) {
        return new AndroidLinearLayout(context, orientation, components);
    }

    @Override
    protected Button button(CharSequence text) {
        return new AndroidButton(context, text);
    }

}
