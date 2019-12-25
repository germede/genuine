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
import org.fluentness.view.View;
import org.fluentness.view.web.HtmlElement;
import org.fluentness.view.web.HtmlView;

import static com.sample.LibraryTranslation.*;
import static org.fluentness.view.web.HtmlFactory.*;
import static org.fluentness.view.web.HtmlFactory.head;

public class Web extends AbstractWebController {

    private final Persistence persistence;

    public Web(Persistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public View template(HtmlElement toInclude) {

        return html(
            head(
                title("The book library made with Fluentness"),
                meta(_name("lang"), _content("en")),
                meta(_charset("UTF-8")),
                link(_rel("stylesheet"), _type("text/css"), _href("https://cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.min.css")),
                link(_rel("stylesheet"), _type("text/css"), _href("/resources/css/styles.css")),
                script(_src("/resources/js/script.min.js"))
            ),
            body(
                div(_class("container"),
                    h2(_class("text_center"), welcome_message),
                    nav(
                        ul(_class("navigation_list"),
                            li(_class("navigation_item"),
                                action(this::books, books)
                            ),
                            li(_class("navigation_item"),
                                action(this::authors, authors)
                            )
                        )
                    ),
                    toInclude
                )
            )
        );
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
            table(persistence.select(Book.all)).appendColumn(book ->
                td(_class("float-right"),
                    action(this::updateBook, _class("button button-outline"), "\uD83D\uDD89"),
                    " ",
                    action(this::deleteBook, _class("button"), "⨯")
                )
            ),
            div(_class("row",
                action(this::createBook, _class("button column"), l10n.create)
            )
        );
    }

    HtmlView createBook(Request request) {
        return div(
            h2(create),
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
            table(persistence.select(Author.all)),
            action(this::createAuthor, CLASS + "button column", l10n.create)
        );
    }

    HtmlView createAuthor(Request request) {
        return div(
            h2(l10n.create),
            form(this::createAuthor, new Author())
        );
    }

    CharSequence notFound(Request request) {
        return page_not_found;
    }

    CharSequence serverError(Request request) {
        return server_error;
    }

}