package org.fluentness.prototype.controller;

import org.fluentness.prototype.repository.NoteRepository;
import org.fluentness.prototype.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.view.html.Html;

import static org.fluentness.prototype.service.Localization.*;
import static org.fluentness.view.AbstractWebView.*;
import static org.fluentness.view.html.HtmlAttribute.CLASS;

public class WebNotesController extends AbstractWebController<WebView> {

    private final NoteRepository noteRepository;

    @BasePath("/notes")
    public WebNotesController(WebView web, NoteRepository noteRepository) {
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
                    forEach(noteRepository.selectAll(), note ->
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