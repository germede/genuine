package com.sample.controller;

import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import com.sample.repository.User;
import com.sample.repository.UserRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.html.HtmlView;
import org.fluentness.service.translation.TranslationService;

import static com.sample.service.TranslationService.*;
import static org.fluentness.controller.web.markup.html.HtmlViewFactory.action;
import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class WebController extends AbstractWebController {

    private BookRepository bookRepository;
    private UserRepository userRepository;
    private TranslationService i18n;

    public WebController(
        BookRepository bookRepository,
        UserRepository userRepository,
        TranslationService translationService
    ) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.i18n = translationService;
    }

    @Action(path = "/")
    public WebView index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    public WebView books(Request request) {
        return base(
            div(_class("row"),
                table(bookRepository.findAll(Book.class),
                    i18n.translate(book_title)
                )
            ),
            div(_class("row"),
                action(this::booksCreate, _class("button column"), () -> i18n.translate(create))
            )
        );
    }

    @Action(path = "/books/create")
    public WebView booksCreate(Request request) {
        return base(
            div(_class("row"),
                div(_class("column"),
                    h2(() -> i18n.translate(create)),
                    form(new Book(), this::booksCreate)
                )
            )
        );
    }

    @Action(path = "/users")
    public WebView users(Request request) {
        return base(
            div(_class("row"),
                table(userRepository.findAll(User.class),
                    i18n.translate(user_username),
                    i18n.translate(user_password)
                )
            ),
            div(_class("row"),
                action(this::usersCreate, _class("button column"), () -> i18n.translate(create))
            )
        );
    }

    @Action(path = "/users/create")
    public Object usersCreate(Request request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !username.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userRepository.create(user);
            return redirect(this::users);
        }

        return base(
            div(_class("row"),
                div(_class("column"),
                    h2(() -> i18n.translate(create)),
                    form(new User(), this::usersCreate)
                )
            )
        );
    }

    @Action(path = "/authors")
    private Object authors(Request request) {
        return null;
    }

    private WebView base(HtmlView... toInclude) {
        return html(
            head(
                title(() -> "The book library made with Fluentness"),
                meta(_name("lang"), _content("en")),
                meta(_charset("UTF-8")),
//                link().rel("stylesheet").type("text/css").href("/resources/css/milligram.min.css"),
                link(_rel("stylesheet"), _type("text/css"), _href("https://cdnjs.cloudflare.com/ajax/libs/milligram/1.3.0/milligram.min.css")),
                link(_rel("stylesheet"), _type("text/css"), _href("/resources/css/styles.css")),
                script(_src("/resources/js/script.min.js"))
            ),
            body(
                div(_class("container"),
                    h2(_class("text_center"), () -> i18n.translate(welcome_message, "Person")),
                    nav(
                        ul(_class("navigation_list"),
                            li(_class("navigation_item"),
                                action(this::books, () -> i18n.translate(books))
                            ),
                            li(_class("navigation_item"),
                                action(this::authors, () -> i18n.translate(authors))
                            ),
                            li(_class("navigation_item"),
                                action(this::users, () -> i18n.translate(users))
                            )
                        )
                    ),
                    div(toInclude)
                )
            )
        );
    }

}