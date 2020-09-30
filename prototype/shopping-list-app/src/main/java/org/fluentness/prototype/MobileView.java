package org.fluentness.prototype;

import org.fluentness.view.AbstractMobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;
import org.fluentness.view.component.text.form.Button;

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
//            button1 = button(_cancel),
//            button(_welcome_message),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            ),
            navigation()
        );
    }

    @Override
    protected Separator separator() {
        return null;
    }

    @Override
    protected Navigation navigation() {
        return null;
    }

    @Override
    protected Button button(Button.Type type, CharSequence text) {
        return null;
    }

    @Override
    protected Heading heading(Heading.Level level, CharSequence text) {
        return null;
    }

    @Override
    protected Text text(CharSequence text) {
        return null;
    }

}