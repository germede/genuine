package com.sample.controller;

import com.sample.model.AuthorModel;
import com.sample.model.BookModel;
import com.sample.model.UserModel;
import com.sample.repository.*;
import com.sample.view.WebView;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.server.Request;

import static com.sample.localization.LibraryTranslation.page_not_found;
import static org.fluentness.localization.Translation.create;
import static org.fluentness.localization.Translation.faulty;
import static org.fluentness.view.web.HtmlFactory.*;

public class WebController extends AbstractWebController<WebView> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public WebController(
        BookRepository bookRepository,
        AuthorRepository authorRepository,
        UserRepository userRepository
    ) {
        super(WebView.class);
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    @Action(path = "/")
    public org.fluentness.view.web.WebView index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    public org.fluentness.view.web.WebView books(Request request) {
        return div(
            table(bookRepository.findAll(BookModel.class)).appendColumn(book ->
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
    public org.fluentness.view.web.WebView createBook(Request request) {
        return div(
            h2(create::translate),
            form(new BookModel(), this::createBook)
        );
    }

    @Action(path = "/books/update/<id>")
    public String updateBook(Request request) {
        return "asdf";
    }

    @Action(path = "/books/delete/<id>")
    public String deleteBook(Request request) {
        return "asdf";
    }

    @Action(path = "/authors")
    public org.fluentness.view.web.WebView authors(Request request) {
        return div(
            table(authorRepository.findAll(AuthorModel.class)),
            action(this::createAuthor, _class("button column"), create::translate)
        );
    }

    @Action(path = "/authors/create")
    public org.fluentness.view.web.WebView createAuthor(Request request) {
        return div(
            h2(create::translate),
            form(new AuthorModel(), this::createAuthor)
        );
    }

    @Action(path = "/users")
    public org.fluentness.view.web.WebView users(Request request) {
        return div(
            table(userRepository.findAll(UserModel.class)),
            action(this::createUser, _class("button column"), create::translate)
        );
    }

    @Action(path = "/users/create")
    public org.fluentness.view.web.WebView createUser(Request request) {
        return div(
            h2(create::translate),
            form(new UserModel(), this::createUser)
        );
    }

    @Action(path = "/404")
    public org.fluentness.view.web.WebView notFound(Request request) {
        return page_not_found::translate;
    }

    @Action(path = "/500")
    public org.fluentness.view.web.WebView serverError(Request request) {
        return faulty::translate;
    }

}