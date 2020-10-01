package org.fluentness.prototype.controller;

import org.fluentness.controller.view.AbstractWebViewController;
import org.fluentness.prototype.model.Note;
import org.fluentness.prototype.repository.NoteRepository;
import org.fluentness.prototype.view.NoteView;
import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.view.component.text.HtmlText;

public class NoteController extends AbstractWebViewController<NoteView> {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteController(NoteView view, NoteRepository noteRepository, UserRepository userRepository) {
        super(view, "/notes");
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;

        onPageLoad(this::loadNotes);
        onClick(view.newButton, this::replaceText);
    }

    private void loadNotes() {
        noteRepository.selectAll().forEach(
            note -> view.noteList.appendChild(new HtmlText(note.getTitle()))
        );
    }

    private void replaceText() {
        Note note = new Note();
        note.setTitle("hallo");
        note.setDescription("description");
        User user = new User();
        user.setUsername("test");
        user.setPassword("pass");
        note.setUser(user);
        userRepository.insert(user);
        noteRepository.insert(note);
        view.newButton.setText("HA!");
    }
}