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
        super(new Web());
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    @Action(path = "/")
    WebView index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    WebView books(Request request) {
        return web.view(
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

    @Action(path = "/books/create")
    WebView createBook(Request request) {
        return web.view(
            h2(create::translate),
            form(new Book(), this::createBook)
        );
    }

    @Action(path = "/books/update/1")
    WebView updateBook(Request request) {
        return web.view(() -> "asdf");
    }

    @Action(path = "/books/delete/1")
    WebView deleteBook(Request request) {
        return web.view(() -> "asdf");
    }

    @Action(path = "/authors")
    WebView authors(Request request) {
        return web.view(
            table(authorRepository.findAll(Author.class)),
            action(this::createAuthor, _class("button column"), create::translate)
        );
    }

    @Action(path = "/authors/create")
    WebView createAuthor(Request request) {
        return web.view(
            h2(create::translate),
            form(new Author(), this::createAuthor)
        );
    }

    @Action(path = "/users")
    WebView users(Request request) {
        return web.view(
            table(userRepository.findAll(User.class)),
            action(this::createUser, _class("button column"), create::translate)
        );
    }

    @Action(path = "/users/create")
    Object createUser(Request request) {
        return web.view(
            h2(create::translate),
            form(new User(), this::createUser)
        );
    }

    @Action(path = "/404")
    WebView notFound(Request request) {
        return web.view(page_not_found::translate);
    }

    @Action(path = "/500")
    WebView serverError(Request request) {
        return web.view(faulty::translate);
    }

}