package org.fluentness.prototype.note;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

public class NoteView extends AbstractWebView {

    Button newButton = button("one");
    LinearLayout noteList = linearLayout();

    public NoteView() {
        super("Notes");
        structure(
            linearLayout(
                newButton,
                noteList
            )
        );
    }
}