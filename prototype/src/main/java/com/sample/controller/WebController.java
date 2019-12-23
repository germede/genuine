package com.sample.controller;

import org.fluentness.controller.web.Handleer;
import org.fluentness.controller.web.Route;
import org.fluentness.controller.web.Routing;
import com.sample.model.Author;
import com.sample.model.Book;
import com.sample.model.User;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebAction;
import org.fluentness.persistence.Persistence;
import org.fluentness.server.Request;
import org.fluentness.view.web.HtmlView;

import static com.sample.LibraryTranslation.page_not_found;
import static org.fluentness.view.web.HtmlAttribute.CLASS;
import static org.fluentness.view.web.HtmlFactory.*;

public class WebController extends AbstractWebController {

    private final Persistence persistence;

    public WebController(Persistence persistence) {
        this.persistence = persistence;
    }

    protected void routing() {
        get("/", this::index);
        get("/books", this::books);
        get("/books/create", this::createBook);
        get("/books/update/<id>", this::updateBook);
        get("/books/delete/<id>", this::deleteBook);
        get("/authors", this::authors);
        get("/authors/create", this::createAuthor);
        get("/404", this::notFound);
        get("/500", this::serverError);
    }

    HtmlView index(Request request) {
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

    HtmlView createBook(Request request) {
        return div(
            h2(l10n.localize(l10n.create)),
            form(this::createBook, new Book())
        );
    }

    String updateBook(Request request) {
        return "asdf";
    }

    String deleteBook(Request request) {
        return "asdf";
    }

    HtmlView authors(Request request) {
        return div(
            table(authorRepository.select(Author.class)),
            action(this::createAuthor, CLASS + "button column", l10n.create)
        );
    }

    HtmlView createAuthor(Request request) {
        return div(
            h2(l10n.create),
            form(this::createAuthor, new Author())
        );
    }

    String notFound(Request request) {
        return page_not_found.translate();
    }

    String serverError(Request request) {
        return l10n.server_error;
    }

}