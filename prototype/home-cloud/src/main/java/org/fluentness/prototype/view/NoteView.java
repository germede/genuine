package org.fluentness.prototype.view;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

public class NoteView extends AbstractWebView {

    public Button newButton;
    public LinearLayout noteList;

    public NoteView() {
        super("Notes");
    }

    @Override
    protected Component structure() {
        return linearLayout(
            newButton = button("one"),
            noteList = linearLayout()
        );
    }
}