package org.fluentness.prototype.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.layout.Layout;
import org.fluentness.view.component.layout.LinearLayout;

import static org.fluentness.prototype.service.Localization.*;
import static org.fluentness.view.component.layout.LinearLayout.VERTICAL;

public class MobileView extends AbstractMobileView {

    private LinearLayout root;
    public Button button1;

    public MobileView() {
        super();
        root.setPadding(20,20,20,20);
    }

    @Override
    protected Layout structure() {
        return root = linearLayout(VERTICAL,
            button1 = button(_accept),
            button(_cancel),
            button(_welcome_message)
        );
    }

}