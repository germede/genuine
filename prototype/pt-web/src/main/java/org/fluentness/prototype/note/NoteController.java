package org.fluentness.prototype.note;

import org.fluentness.controller.view.AbstractWebViewController;
import org.fluentness.prototype.user.User;
import org.fluentness.prototype.user.UserRepository;

public class NoteController extends AbstractWebViewController<NoteView> {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteController(NoteView view, NoteRepository noteRepository, UserRepository userRepository) {
        super(view, "/notes");
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
        onClick(view.newButton, this::replaceText);
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