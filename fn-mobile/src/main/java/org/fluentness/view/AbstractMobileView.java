package org.fluentness.view;

import android.content.Context;
import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;
import org.fluentness.view.template.Template;

public abstract class AbstractMobileView extends AbstractView {

    public static Context context;

    @Override
    protected Template template(String title, Container container) {
        return null;
    }

    @Override
    protected LinearLayout linearLayout(Component... components) {
        return null;
    }

    @Override
    protected Button button(String text) {
        return null;
    }

}
