package org.fluentness.view;

import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;

public abstract class AbstractView<
    C extends Component,
    Co extends Container,
    B extends Button,
    LL extends LinearLayout
    >

    implements View {

    protected abstract Co structure();

    protected abstract LL linearLayout(int orientation, C... components);

    protected abstract B button(CharSequence text);


}
