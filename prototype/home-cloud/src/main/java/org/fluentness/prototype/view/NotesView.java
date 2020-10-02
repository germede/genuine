package org.fluentness.prototype.view;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

import static org.fluentness.prototype.service.Localization._notes;
import static org.fluentness.service.localization.AbstractLocalization._create;

public class NotesView extends AbstractWebView {

    public Button newButton;
    public LinearLayout noteList;

    public NotesView() {
        super(_notes);
    }

    @Override
    protected Component structure() {
        return linearLayout(
            newButton = button(_create),
            noteList = linearLayout()
        );
    }
}