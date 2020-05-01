package com.sample.controller;

import com.sample.repository.Note;
import com.sample.repository.NoteRepository;
import com.sample.service.Calendar;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;
import org.fluentness.service.mail.Mail;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.template.html.HtmlAttribute.ID;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends AbstractWebController<WebView> {

    private final Calendar calendar;
    private final NoteRepository noteRepository;
    private final Mail mail;

    public WebController(Calendar calendar, NoteRepository noteRepository, Mail mail) {
        super(new WebView());
        this.calendar = calendar;
        this.noteRepository = noteRepository;
        this.mail = mail;
    }

    @Action(path = "/")
    Html index() {
        return notes();
    }

    @Action(path = "/notes")
    Html notes() {
        noteRepository.insert(new Note("Title", "Description", 0));

        return div(
            table(
                thead(
                    th(note_title),
                    th(note_description),
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
                button(CLASS + "button column", create)
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

    @Action(path = "/authors")
    public Html authors() {
        return div(
//            table(authorRepository.findAll()),
            button(CLASS + "button column", ID + "createAuthor", create)
        );
    }

    @Action(path = "/calendar", selector = "#calendar")
    Html calendar(int year, int month) {
        return calendar.renderMonthCalendar(year, month);
    }


    @Action(path = "/sendMessage")
    void sendMessage(String message) {
        mail.send("info@library.com", "", message);
    }
}