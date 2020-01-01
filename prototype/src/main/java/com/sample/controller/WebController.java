package com.sample.controller;

import com.sample.repository.Author;
import com.sample.repository.AuthorRepository;
import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.Controller;
import org.fluentness.controller.web.view.WebRenderable;
import org.fluentness.controller.web.view.html.Html;
import org.fluentness.controller.web.view.html.style.WebStyle;
import org.fluentness.service.server.Request;

import static com.sample.LibraryTranslation.*;
import static org.fluentness.controller.web.view.html.HtmlFactory.*;

public class WebController extends Controller<Web> {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    protected WebController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    protected WebStyle getStyle() {
        return null;
    }

    @Override
    protected WebRenderable getView(WebRenderable toInclude) {
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
                                action(controller::books, books)
                            ),
                            li(_class("navigation_item"),
                                action(controller::authors, authors)
                            )
                        )
                    ),
                    toInclude
                )
            )
        );
    }

    @Override
    protected void routing() {
        get("/", request -> redirect());
        get("/books", this::books);
        get("/books/create", this::createBook);
        get("/books/update/<id>", this::updateBook);
        get("/books/delete/<id>", this::deleteBook);
        get("/authors", this::authors);
        get("/authors/create", this::createAuthor);
        get("/notFound", request -> "Page not found");
        get("/serverError", request -> "Server error");
    }

    Html index(Request request) {
        return books(request);
    }

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

    Html createBook(Request request) {
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

    Html authors(Request request) {
        return div(
            table(authorRepository.findAll()),
            action(this::createAuthor, _class("button column"), create)
        );
    }

    Html createAuthor(Request request) {
        return div(
            h2(create),
            form(this::createAuthor, new Author())
        );
    }
}