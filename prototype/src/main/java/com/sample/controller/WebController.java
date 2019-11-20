package com.sample.controller;

import com.sample.repository.Book;
import com.sample.repository.BookRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.WebView;
import org.fluentness.service.mailing.MailingService;
import org.fluentness.service.translation.TranslationService;

import javax.mail.MessagingException;

public class WebController extends AbstractWebController<Web> {

    private BookRepository bookRepository;
    private TranslationService i18n;
    private MailingService mailingService;

    public WebController(BookRepository bookRepository, TranslationService i18n, MailingService mailingService) {
        this.bookRepository = bookRepository;
        this.i18n = i18n;
        this.mailingService = mailingService;
    }

    @Override
    protected Web initViews() {
        return new Web(this, i18n);
    }

    @Action(path = "/")
    public WebView index() {
        return listBooks();
    }

    @Action(path = "/listBooks", authentication = true)
    public WebView listBooks() {
        return web.listBooks(bookRepository.findAll(Book.class));
    }

    @Action(path = "/testmail")
    public void testmail() throws MessagingException {
        mailingService.mail("example@example.com")
            .from("example@example.com")
            .subject("hey")
            .content(listBooks(), "/home/germede/test")
            .send();
    }

}