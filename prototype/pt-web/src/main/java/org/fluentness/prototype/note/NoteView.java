package org.fluentness.prototype.note;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.form.Button;

import java.util.Date;

public class NoteView extends AbstractWebView {

    LinearLayout root;
    Button button1;
    Button button2;
    Table table;

    public NoteView() {
        super("Notes");
    }

    @Override
    protected Component structure() {
        return root = linearLayout(
            button1 = button("one"),
            button2 = button("two"),
            button("three"),
            table = table(
                header("this", "is", "a", "header"),
                row("this", "is", "a", "row"),
                row(123, false, new Date(0))
            ),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            )
        );
    }


}