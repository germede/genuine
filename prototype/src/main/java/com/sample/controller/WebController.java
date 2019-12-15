package com.sample.controller;

import com.sample.localization.StringLocalization;
import com.sample.model.AuthorModel;
import com.sample.model.BookModel;
import com.sample.repository.AuthorRepository;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.server.Request;
import org.fluentness.view.web.HtmlView;

import static org.fluentness.view.web.HtmlAttribute.CLASS;
import static org.fluentness.view.web.HtmlFactory.*;

public class WebController extends AbstractWebController {

    private StringLocalization l10n;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public WebController(
        StringLocalization l10n,
        BookRepository bookRepository,
        AuthorRepository authorRepository
    ) {
        this.l10n = l10n;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Action(path = "/")
    public HtmlView index(Request request) {
        return books(request);
    }

    @Action(path = "/books")
    public HtmlView books(Request request) {
        return div(
            table(bookRepository.select(BookModel.class)).appendColumn(book ->
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

    @Action(path = "/books/create")
    public HtmlView createBook(Request request) {
        return div(
            h2(l10n.localize(l10n.create)),
            form(this::createBook, new BookModel())
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
    public HtmlView authors(Request request) {
        return div(
            table(authorRepository.select(AuthorModel.class)),
            action(this::createAuthor, CLASS + "button column", l10n.create)
        );
    }

    @Action(path = "/authors/create")
    public HtmlView createAuthor(Request request) {
        return div(
            h2(l10n.create),
            form(this::createAuthor, new AuthorModel())
        );
    }

    @Action(path = "/404")
    public String notFound(Request request) {
        return l10n.page_not_found;
    }

    @Action(path = "/500")
    public String serverError(Request request) {
        return l10n.server_error;
    }

}