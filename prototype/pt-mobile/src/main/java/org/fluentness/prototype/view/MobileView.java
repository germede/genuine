package org.fluentness.prototype.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Button;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;

import static org.fluentness.prototype.service.Localization.*;
import static org.fluentness.view.container.LinearLayout.VERTICAL;

public class MobileView extends AbstractMobileView {

    private LinearLayout root;
    public Button button1;

    @Override
    protected Container structure() {
        return root = linearLayout(VERTICAL,
            button1 = button(_accept),
            button(_cancel),
            button(_welcome_message)
        );
    }

    @Override
    protected void style() {
        root.padding(20,20,20,20);
    }
}