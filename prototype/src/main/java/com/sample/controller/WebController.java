package com.sample.controller;

import com.sample.repository.*;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.html.HtmlView;

import static com.sample.service.TranslationService.*;
import static org.fluentness.controller.web.markup.html.HtmlViewFactory.*;

public class WebController extends AbstractWebController {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public WebController(
        BookRepository bookRepository,
        AuthorRepository authorRepository,
        UserRepository userRepository
    ) {
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
        return base(
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
        return base(
            h2(create::translate),
            form(new Book(), this::createBook)
        );
    }

    @Action(path = "/books/update/1")
    public WebView updateBook(Request request) {
        return base(() -> "asdf");
    }

    @Action(path = "/books/delete/1")
    public WebView deleteBook(Request request) {
        return base(() -> "asdf");
    }

    @Action(path = "/authors")
    public WebView authors(Request request) {
        return base(
            table(authorRepository.findAll(Author.class)),
            action(this::createAuthor, _class("button column"), create::translate)
        );
    }

    @Action(path = "/authors/create")
    public WebView createAuthor(Request request) {
        return base(
            h2(create::translate),
            form(new Author(), this::createAuthor)
        );
    }

    @Action(path = "/users")
    public WebView users(Request request) {
        return base(
            table(userRepository.findAll(User.class)),
            action(this::createUser, _class("button column"), create::translate)
        );
    }

    @Action(path = "/users/create")
    public Object createUser(Request request) {
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
            h2(create::translate),
            form(new User(), this::createUser)
        );
    }

    @Action(path = "/404")
    public WebView notFound(Request request) {
        return base(page_not_found::translate);
    }

    @Action(path = "/500")
    public WebView serverError(Request request) {
        return base(faulty::translate);
    }

    private HtmlView base(HtmlView... toInclude) {
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
                    h2(_class("text_center"), welcome_message::translate),
                    nav(
                        ul(_class("navigation_list"),
                            li(_class("navigation_item"),
                                action(this::books, books::translate)
                            ),
                            li(_class("navigation_item"),
                                action(this::authors, authors::translate)
                            )
                        )
                    ),
                    div(toInclude)
                )
            )
        );
    }
}