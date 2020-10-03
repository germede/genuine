package org.fluentness.prototype.controller;

import org.fluentness.controller.WebController;
import org.fluentness.prototype.model.Note;
import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.NoteRepository;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.prototype.view.NotesView;

import static org.fluentness.service.server.RequestMethod.POST;

public class NoteController extends WebController<NotesView> {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public NoteController(NotesView view, NoteRepository noteRepository, UserRepository userRepository) {
        super(view, "/notes");
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;

        onClick(view.newButton, this::newNote);
    }


    @Override
    protected void onPageLoad() {
        noteRepository.selectAll().forEach(note -> view.notes.addRow(note.getTitle(), note.getDescription()));
    }

    @Action(method = POST, path = "/new")
    public void newNote(String title, String description) {
        Note note = new Note();
        note.setTitle(title);
        note.setDescription(description);
        User user = new User();
        user.setUsername("test");
        user.setPassword("pass");
        note.setUser(user);
        userRepository.insert(user);
        noteRepository.insert(note);

        view.newModal.hide();
        view.notes.addRow(note.getTitle(), note.getDescription());
    }

    private void newNote() {
        view.newModal.show();
    }
}