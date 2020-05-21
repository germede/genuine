package org.fluentness.view;

import android.content.Context;
import org.fluentness.view.component.AndroidButton;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.LinearLayout;

public abstract class AbstractMobileView extends AbstractView {

    public static Context context;

    @Override
    protected LinearLayout linearLayout(Component... components) {
        return null;
    }

    @Override
    protected AndroidButton button(CharSequence text) {
        return new AndroidButton(context, text);
    }

}
