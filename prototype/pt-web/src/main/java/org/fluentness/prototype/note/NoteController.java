package org.fluentness.prototype.note;

import org.fluentness.controller.view.AbstractWebViewController;

public class NoteController extends AbstractWebViewController<NoteView> {

    private final NoteRepository noteRepository;

    public NoteController(NoteView view, NoteRepository noteRepository) {
        super(view, "/notes");
        this.noteRepository = noteRepository;
        onClick(view.button1, this::doNothing);
        onClick(view.button2, this::doSomething);
    }

    private void doSomething() {
        System.out.println("TEST");
    }

    private void doNothing() {

        view.button1.setText("HA!");
        view.root.appendChild(view.button1);
    }

}

//package org.fluentness.prototype.controller;
//
//import org.fluentness.controller.AbstractWebController;
//import org.fluentness.prototype.notes.NoteRepository;
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