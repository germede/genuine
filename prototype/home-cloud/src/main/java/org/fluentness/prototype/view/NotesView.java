package org.fluentness.prototype.view;

import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.modal.HtmlModal;
import org.fluentness.view.component.button.HtmlButton;
import org.fluentness.view.component.text.Heading;

import static org.fluentness.prototype.service.Localization.*;
import static org.fluentness.service.localization.BaseLocalization._create;

public class NotesView extends WebView {

    public HtmlButton newButton;
    public HtmlModal newModal;
    public HtmlLinearLayout noteList;

    @Override
    protected HtmlComponent structure() {
        title = _notes;
        return linearLayout(
            newButton = button(_create),
            newModal = modal(
                heading(Heading.Level.H6, _create),
                form(
                    field("title", _note_title),
                    field("description", _note_description)
                )
            ),
            noteList = linearLayout()
        );
    }
}