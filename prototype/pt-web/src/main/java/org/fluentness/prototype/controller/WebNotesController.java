//package org.fluentness.prototype.controller;
//
//import org.fluentness.controller.AbstractWebController;
//import org.fluentness.prototype.repository.NoteRepository;
//import org.fluentness.prototype.view.WebView;
//import org.fluentness.service.dispatcher.ActionDispatcher;
//import org.fluentness.view.container.HtmlContainer;
//
//import static org.fluentness.view.AbstractWebView.div;
//
//public class WebNotesController extends AbstractWebController<WebView> {
//
//    private final NoteRepository noteRepository;
//
//    public WebNotesController(WebView web, ActionDispatcher dispatcher, NoteRepository noteRepository) {
//        super(web, dispatcher);
//        this.noteRepository = noteRepository;
//    }
//
//    @Action(path = "/notes")
//    HtmlContainer notes() {
//        return div(
////            table(
////                thead(
////                    th(_note_title),
////                    th(_note_description),
////                    th("")
////                ),
////                tbody(
////                    forEach(noteRepository.selectAll(), note ->
////                        tr(
////                            td(note.getTitle()),
////                            td(note.getDescription()),
////                            td(
////                                button(CLASS + "button button-outline", "\uD83D\uDD89"),
////                                button(CLASS + "button", "⨯")
////                            )
////                        )
////                    )
////                )
////            ),
////            div(CLASS + "row",
////                button(CLASS + "button column", _create)
////            )
//        );
//    }
//
//
//}