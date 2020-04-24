package com.sample.controller;

import com.sample.repository.AuthorRepository;
import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.Controller;
import org.fluentness.controller.web.template.html.Html;
import org.fluentness.service.mailer.Mailer;

import static com.sample.service.LibraryTranslator.create;
import static org.fluentness.controller.web.template.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.template.html.HtmlAttribute.ID;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends Controller<Web> {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final Mailer mailer;

    public WebController(BookRepository bookRepository, AuthorRepository authorRepository, Mailer mailer) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.mailer = mailer;
    }

    @Action(path = "/")
    Html index() {
        return books();
    }

    @Action(path = "/books", selector = "#books")
    Html books() {

        bookRepository.insert(new Book("title1","cover2","genre3","synopsis4",1324,true,null));


        return div(

            table(
                thead(
                    th("asdf")
                ),
                tbody(
                    forEach(bookRepository.select(), book ->
                        tr(
                            td("test"),
                            td(CLASS + "float-right",
                                button(ID + "updateBook", CLASS + "button button-outline", "\uD83D\uDD89"),
                                button(ID + "deleteBook", CLASS + "button", "⨯")
                            )
                        )
                    )
                )
            ),
            div(CLASS + "row",
                button(ID + "createBook", CLASS + "button column", create)
            )
        );
    }

    @Action(path = "/books/create")
    Html createBook() {
        return div(
            h2(create)
//            form(this::createBook, new Book())
        );
    }

    @Action(path = "/books/update/<id>")
    String updateBook(int id) {
        return "asdf";
    }

    @Action(path = "/books/delete/<id>")
    String deleteBook(int id) {
        return "asdf";
    }

    @Action(path = "/authors", selector = "#authors")
    Html authors() {
        return div(
//            table(authorRepository.findAll()),
            button(CLASS + "button column", ID + "createAuthor", create)
        );
    }

    @Action(path = "/authors/create", selector = "#createAuthor")
    Html createAuthor() {
        return div(
            h2(create)
//            form(this::createAuthor, new Author())
        );
    }

    @Action(path = "/sendMessage")
    void sendMessage(String message) {
        mailer.send("info@library.com", "", message);
    }
}