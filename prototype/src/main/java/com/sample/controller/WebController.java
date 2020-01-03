package com.sample.controller;

import com.sample.repository.AuthorRepository;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.Controller;
import org.fluentness.controller.web.template.html.Html;
import org.fluentness.service.mailer.Mailer;

import static com.sample.LibraryTranslation.create;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends Controller<Web> {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final Mailer mailer;

    public WebController(BookRepository bookRepository, AuthorRepository authorRepository, Mailer mailer) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mailer = mailer;
    }

    @Action(path = "/")
    Html index() {
        return books();
    }

    @Action(path = "/books", selector = "#books")
    Html books() {
        return div(
            table(bookRepository.findAll()).appendColumn(book ->
                td(_class("float-right"),
                    button(_id("#updateBook"), _class("button button-outline"), "\uD83D\uDD89"),
                    " ",
                    button(_id("#deleteBook"), _class("button"), "⨯")
                )
            ),
            div(_class("row"),
                button(_id("#createBook"), _class("button column"), create)
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
            table(authorRepository.findAll()),
            button(_class("button column"), _id("createAuthor"), create)
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
        mailer.send("info@library.com", "", message);
    }
}