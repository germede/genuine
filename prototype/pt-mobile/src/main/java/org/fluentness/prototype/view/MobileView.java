package org.fluentness.prototype.view;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.Navigation;
import org.fluentness.view.component.text.Button;

import static org.fluentness.prototype.service.Localization.*;

public class MobileView extends AbstractMobileView {

    private LinearLayout root;
    public Button button1;
    private LinearLayout linearLayout;
    private Button menu;
    private Navigation nav;

    public MobileView() {
        super();
        root.setPadding(20,20,20,20);
    }

    @Override
    protected Component structure() {
        linearLayout = linearLayout(
            button("hello"),
            button("it's me")
        );
        return root = linearLayout(
            menu = button(_menu),
            button1 = button(_cancel),
            button(_welcome_message),
//            tablayout = tabLayout(
//                tab("First tab", button("button in tab 1")),
//                tab("Second tab", button("button in tab 2")),
//                tab("Third tab", button("button in tab 3"))
//            ),
            nav = navigation(
                menu,
                linearLayout
            )
        );
    }

}