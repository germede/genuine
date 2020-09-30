package org.fluentness.prototype.note;

import org.fluentness.controller.view.AbstractWebViewController;

public class NoteController extends AbstractWebViewController<NoteView> {

    private final NoteRepository noteRepository;

    public NoteController(NoteView view, NoteRepository noteRepository) {
        super(view, "/notes");
        this.noteRepository = noteRepository;
        onClick(view.newButton, this::replaceText);
    }

    private void replaceText() {
        view.newButton.setText("HA!");
    }
}