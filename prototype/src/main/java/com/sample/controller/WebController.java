package com.sample.controller;

import com.sample.repository.Author;
import com.sample.repository.AuthorRepository;
import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.view.html.Html;
import org.fluentness.service.server.Request;

import static com.sample.LibraryTranslation.*;
import static org.fluentness.controller.web.view.html.HtmlFactory.action;
import static org.fluentness.controller.web.view.html.HtmlFactory.*;

public class WebController extends AbstractWebController<Web> {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    protected WebController(BookRepository bookRepository, AuthorRepository authorRepository) {
        super(new Web());
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Action(path = "/")
    Html index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    Html books(Request request) {

        return div(
            table(bookRepository.findAll()).appendColumn(book ->
                td(_class("float-right"),
                    action(this::updateBook, _class("button button-outline"), "\uD83D\uDD89"),
                    " ",
                    action(this::deleteBook, _class("button"), "⨯")
                )
            ),
            div(_class("row"),
                action(this::createBook, _class("button column"), create)
            )
        );
    }

    @Action(path="/books/create")
    Html createBook(Request request) {
        return div(
            h2(create),
            form(this::createBook, new Book())
        );
    }

    @Action(path="/books/update/<id>")
    String updateBook(Request request) {
        return "asdf";
    }

    @Action(path="/books/delete/<id>")
    String deleteBook(Request request) {
        return "asdf";
    }

    @Action(path="/authors")
    Html authors(Request request) {
        return div(
            table(authorRepository.findAll()),
            action(this::createAuthor, _class("button column"), create)
        );
    }

    @Action(path="/authors/create")
    Html createAuthor(Request request) {
        return div(
            h2(create),
            form(this::createAuthor, new Author())
        );
    }

    @Action(path="/404")
    CharSequence notFound(Request request) {
        return page_not_found;
    }

    @Action(path="/500")
    CharSequence serverError(Request request) {
        return server_error;
    }
}