package org.fluentness.prototype.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Button;
import org.fluentness.view.container.Container;

public class MobileView extends AbstractMobileView {

    public Button uno;
    public Button dos;
    public Button tres;

    @Override
    protected Container structure() {
        return linearLayout(
            uno = button("uno"),
            dos = button("dos"),
            tres = button("tres")
        );
    }

    @Override
    protected void style() {

    }
}