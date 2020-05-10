package com.sample.controller;

import com.sample.repository.NoteRepository;
import com.sample.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.view.Html;

import static com.sample.service.Translation.*;
import static org.fluentness.view.HtmlAttribute.CLASS;
import static org.fluentness.view.HtmlFactory.*;

public class WebNotesController extends AbstractWebController<WebView> {

    private final NoteRepository noteRepository;

    @BasePath("/notes")
    public WebNotesController(WebView webView, NoteRepository noteRepository) {
        super(webView);
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