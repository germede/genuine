package org.fluentness.prototype;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

import static org.fluentness.prototype.service.Localization._cancel;
import static org.fluentness.prototype.service.Localization._welcome_message;

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
            navigation()
        );
    }

}