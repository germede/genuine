package org.fluentness.prototype.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Button;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;

import static org.fluentness.view.container.LinearLayout.VERTICAL;

public class MobileView extends AbstractMobileView {

    private LinearLayout root;
    public Button uno;
    public Button dos;
    public Button tres;

    @Override
    protected Container structure() {
        return root = linearLayout(VERTICAL,
            uno = button("uno"),
            dos = button("dos"),
            tres = button("tres")
        );
    }

    @Override
    protected void style() {
        root.padding(20,20,20,20);
    }
}