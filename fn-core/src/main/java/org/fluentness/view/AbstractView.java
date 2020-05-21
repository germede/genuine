package org.fluentness.view;

import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;

public abstract class AbstractView implements View {

    protected abstract Container structure();

    protected abstract void style();

    protected abstract LinearLayout linearLayout(Component... components);

    protected abstract Button button(CharSequence text);


}
