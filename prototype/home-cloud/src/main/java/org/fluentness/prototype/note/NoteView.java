package org.fluentness.prototype.note;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.text.form.Button;

public class NoteView extends AbstractWebView {

    private final NoteRepository noteRepository;
    Button newButton;
    LinearLayout noteList;

    public NoteView(NoteRepository noteRepository) {
        super("Notes");
        this.noteRepository = noteRepository;
    }

    @Override
    protected Component structure() {
        return linearLayout(
            newButton = button("one"),
            noteList = linearLayout()
        );
    }
}