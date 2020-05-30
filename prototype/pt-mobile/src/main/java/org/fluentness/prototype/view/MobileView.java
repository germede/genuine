package org.fluentness.prototype.view;

import org.fluentness.view.FluentnessActivity;
import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.Button;

import static org.fluentness.prototype.service.Localization.*;

public class MobileView extends AbstractMobileView {

    private LinearLayout root;
    public Button button1;

    public MobileView() {
        super("Section 1");
        root.setPadding(20, 20, 20, 20);
    }

    @Override
    protected Component structure() {
        return root = linearLayout(
            button1 = button(_cancel),
            button(_welcome_message),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            ),
            FluentnessActivity.navigation
        );
    }

}