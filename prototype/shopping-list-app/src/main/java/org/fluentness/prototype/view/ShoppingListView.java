package org.fluentness.prototype.view;

import org.fluentness.view.MobileView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.form.Field;
import org.fluentness.view.component.form.Form;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.modal.Modal;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.Text;

import static org.fluentness.service.translator.StringTranslator._cancel;

public class ShoppingListView extends MobileView {

    private LinearLayout root;
    public Button button1;

    public ShoppingListView() {
        super("Section 1");
        root.setPadding(20, 20, 20, 20);
    }

    @Override
    protected Component structure() {
        return root = linearLayout(
            button1 = button(_cancel),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            )
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
    protected Field field(String name, Field.Type type, CharSequence placeholder, boolean required) {
        return null;
    }

    @Override
    protected Form form(Component[] components) {
        return null;
    }

    @Override
    protected Heading heading(Heading.Level level, CharSequence text) {
        return null;
    }

    @Override
    protected Modal modal(Component[] components) {
        return null;
    }

    @Override
    protected Text text(CharSequence text) {
        return null;
    }

}