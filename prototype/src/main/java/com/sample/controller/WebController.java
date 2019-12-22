package com.sample.controller;

import org.fluentness.controller.web.Handleer;
import org.fluentness.controller.web.Route;
import org.fluentness.controller.web.Routing;
import com.sample.repository.Author;
import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import com.sample.repository.User;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Request;
import org.fluentness.controller.web.view.HtmlView;

import static org.fluentness.controller.web.view.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.view.HtmlFactory.*;

public class WebController extends AbstractWebController {

    private final Persistence persistence;
    private final BookRepository bookRepository;

    public WebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    protected Routing getRouting() {
        return routing(
            get("/", this::index),
            get("/books", this::books),
            authenticate(request -> persistence.select(User.class, User.byName, request.getCookie(""))
                get("/books/create", this::createBook),
                get("/books/update/<id>", this::updateBook),
                get("/books/delete/<id>", this::deleteBook)
            ),
            get("/authors", this::authors),
            get("/authors/create", this::createAuthor),
            get("/404", this::notFound),
            get("/500", this::serverError)
        );
    }

    private Route authenticate(Handleer handleer, Route... route) {
        return null;
    }

    private Route get(String path, WebAction action) {

    }

    protected Routing routing(Route... routes) {

    }


    public HtmlView index(Request request) {
        return books(request);
    }

    HtmlView books(Request request) {
        return div(
            table(bookRepository.select(Book.class)).appendColumn(book ->
                td(CLASS + "float-right",
                    action(this::updateBook, CLASS + "button button-outline", "\uD83D\uDD89"),
                    " ",
                    action(this::deleteBook, CLASS + "button", "⨯")
                )
            ),
            div(CLASS + "row",
                action(this::createBook, CLASS + "button column", l10n.create)
            )
        );
    }

    public HtmlView createBook(Request request) {
        return div(
            h2(l10n.localize(l10n.create)),
            form(this::createBook, new Book())
        );
    }

    public String updateBook(Request request) {
        return "asdf";
    }

    public String deleteBook(Request request) {
        return "asdf";
    }

    public HtmlView authors(Request request) {
        return div(
            table(authorRepository.select(Author.class)),
            action(this::createAuthor, CLASS + "button column", l10n.create)
        );
    }

    public HtmlView createAuthor(Request request) {
        return div(
            h2(l10n.create),
            form(this::createAuthor, new Author())
        );
    }

    public String notFound(Request request) {
        return l10n.page_not_found;
    }

    public String serverError(Request request) {
        return l10n.server_error;
    }

}