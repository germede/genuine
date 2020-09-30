package org.fluentness.prototype.note;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

public class NoteView extends AbstractWebView {

    Button newButton = button("one");
    LinearLayout noteList;

    public NoteView(NoteRepository noteRepository) {
        super("Notes");
        noteList = linearLayout(
            forEach(noteRepository.selectAll(), note -> text(note.getTitle()))
        );
        structure(
            linearLayout(
                newButton,
                noteList
            )
        );
    }
}