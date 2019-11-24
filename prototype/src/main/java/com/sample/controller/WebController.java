package com.sample.controller;

import com.sample.repository.*;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.html.HtmlFactory.action;
import static org.fluentness.controller.web.html.HtmlFactory.*;

public class WebController extends AbstractWebController<Web> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public WebController(
        BookRepository bookRepository,
        AuthorRepository authorRepository,
        UserRepository userRepository
    ) {
        super(Web.class);
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void defineRoutes() {
        get("/", this::index);
        get("/books", this::books);
        get("/books/create", this::createBook);
        get("/books/update/1", this::updateBook);
        get("/books/delete/1", this::deleteBook);
        get("/authors", this::authors);
        get("/authors", this::authors);
        get("/authors/create", this::authors);
        get("/users", this::users);
        get("/users/create", this::createUser);
        get("/404", this::notFound);
        get("/500", this::serverError);
    }

    WebView index(Request request) {
        return books(request);
    }

    WebView books(Request request) {
        return div(
            table(bookRepository.findAll(Book.class)).appendColumn(book ->
                td(_class("float-right"),
                    action(this::updateBook, _class("button button-outline"), () -> "\uD83D\uDD89"),
                    () -> " ",
                    action(this::deleteBook, _class("button"), () -> "⨯")
                )
            ),
            div(_class("row"),
                action(this::createBook, _class("button column"), create::translate)
            )
        );
    }

    WebView createBook(Request request) {
        return div(
            h2(create::translate),
            form(new Book(), this::createBook)
        );
    }

    String updateBook(Request request) {
        return "asdf";
    }

    String deleteBook(Request request) {
        return "asdf";
    }

    WebView authors(Request request) {
        return div(
            table(authorRepository.findAll(Author.class)),
            action(this::createAuthor, _class("button column"), create::translate)
        );
    }

    WebView createAuthor(Request request) {
        return div(
            h2(create::translate),
            form(new Author(), this::createAuthor)
        );
    }

    WebView users(Request request) {
        return div(
            table(userRepository.findAll(User.class)),
            action(this::createUser, _class("button column"), create::translate)
        );
    }

    WebView createUser(Request request) {
        return div(
            h2(create::translate),
            form(new User(), this::createUser)
        );
    }

    WebView notFound(Request request) {
        return page_not_found::translate;
    }

    WebView serverError(Request request) {
        return faulty::translate;
    }

}