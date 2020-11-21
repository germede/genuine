package org.fluentness.prototype.view;

import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.button.HtmlButton;
import org.fluentness.view.component.modal.HtmlModal;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.text.Heading;

import static org.fluentness.prototype.service.Translator.*;
import static org.fluentness.service.translator.StringTranslator._create;

public class NotesView extends WebView {

    public HtmlButton newButton;
    public HtmlModal newModal;
    public HtmlTable notes;

    @Override
    protected HtmlComponent structure() {
        title = _notes;
        return linearLayout(
            newButton = button(_create),
            newModal = modal(
                heading(Heading.Level.H6, _create),
                form("/notes/new",
                    field("title", _note_title),
                    field("description", _note_description),
                    submit()
                )
            ),
            notes = table(
                header(_note_title, _note_description)
            )
        );
    }
}