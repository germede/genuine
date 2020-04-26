package com.sample.controller;

import com.sample.repository.NoteRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;
import org.fluentness.service.mail.Mail;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends AbstractWebController<WebView> {

    private final NoteRepository noteRepository;
    private final Mail mail;

    public WebController(NoteRepository noteRepository, Mail mail) {
        super(new WebView());
        this.noteRepository = noteRepository;
        this.mail = mail;
    }

    @Action(path = "/")
    Html index() {
        return notes();
    }

    @Action(path = "/books", selector = "#books")
    Html notes() {


        return div(

            table(
                thead(
                    th("asdf")
                ),
                tbody(
                    forEach(noteRepository.select(), note ->
                        tr(
                            td("test"),
                            td(CLASS + "float-right",
                                button(ID + "updateBook", CLASS + "button button-outline", "\uD83D\uDD89"),
                                button(ID + "deleteBook", CLASS + "button", "⨯")
                            )
                        )
                    )
                )
            ),
            div(CLASS + "row",
                button(ID + "createBook", CLASS + "button column", create)
            )
        );
    }

    @Action(path = "/books/create")
    Html createBook() {
        return div(
            h2(create)
//            form(this::createBook, new Book())
        );
    }

    @Action(path = "/books/update/<id>")
    String updateBook(int id) {
        return "asdf";
    }

    @Action(path = "/books/delete/<id>")
    String deleteBook(int id) {
        return "asdf";
    }

    @Action(path = "/authors", selector = "#authors")
    Html authors() {
        return div(
//            table(authorRepository.findAll()),
            button(CLASS + "button column", ID + "createAuthor", create)
        );
    }

    @Action(path = "/authors/create", selector = "#createAuthor")
    Html createAuthor() {
        return div(
            h2(create)
//            form(this::createAuthor, new Author())
        );
    }

    @Action(path = "/sendMessage")
    void sendMessage(String message) {
        mail.send("info@library.com", "", message);
    }
}