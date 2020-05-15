package com.sample.controller;

import com.sample.repository.NoteRepository;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.html.Html;

import static com.sample.service.StringTranslator.*;
import static org.fluentness.controller.AbstractWeb.*;
import static org.fluentness.controller.html.HtmlAttribute.CLASS;

public class WebNotesController extends AbstractWebController<Web> {

    private final NoteRepository noteRepository;

    @BasePath("/notes")
    public WebNotesController(Web web, NoteRepository noteRepository) {
        super(web);
        this.noteRepository = noteRepository;
    }

    @Action
    Html notes() {
        return div(
            table(
                thead(
                    th(_note_title),
                    th(_note_description),
                    th("")
                ),
                tbody(
                    forEach(noteRepository.select(), note ->
                        tr(
                            td(note.getTitle()),
                            td(note.getDescription()),
                            td(
                                button(CLASS + "button button-outline", "\uD83D\uDD89"),
                                button(CLASS + "button", "⨯")
                            )
                        )
                    )
                )
            ),
            div(CLASS + "row",
                button(CLASS + "button column", _create)
            )
        );
    }


}