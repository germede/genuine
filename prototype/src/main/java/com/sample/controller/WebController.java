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
    public WebView index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    public WebView books(Request request) {
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

    @Action(path = "/books/create")
    public WebView createBook(Request request) {
        return div(
            h2(create::translate),
            form(new Book(), this::createBook)
        );
    }

    @Action(path = "/books/update/1")
    public WebView updateBook(Request request) {
        return () -> "asdf";
    }

    @Action(path = "/books/delete/1")
    public WebView deleteBook(Request request) {
        return () -> "asdf";
    }

    @Action(path = "/authors")
    public WebView authors(Request request) {
        return div(
            table(authorRepository.findAll(Author.class)),
            action(this::createAuthor, _class("button column"), create::translate)
        );
    }

    @Action(path = "/authors/create")
    public WebView createAuthor(Request request) {
        return div(
            h2(create::translate),
            form(new Author(), this::createAuthor)
        );
    }

    @Action(path = "/users")
    public WebView users(Request request) {
        return div(
            table(userRepository.findAll(User.class)),
            action(this::createUser, _class("button column"), create::translate)
        );
    }

    @Action(path = "/users/create")
    public Object createUser(Request request) {
        return div(
            h2(create::translate),
            form(new User(), this::createUser)
        );
    }

    @Action(path = "/404")
    public WebView notFound(Request request) {
        return div(page_not_found::translate);
    }

    @Action(path = "/500")
    public WebView serverError(Request request) {
        return div(faulty::translate);
    }

}