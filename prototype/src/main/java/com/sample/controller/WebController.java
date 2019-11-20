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
    private TranslationService translationService;
    private MailingService mailingService;

    public WebController(
        BookRepository bookRepository,
        TranslationService translationService,
        MailingService mailingService
    ) {
        this.bookRepository = bookRepository;
        this.translationService = translationService;
        this.mailingService = mailingService;
    }

    @Override
    protected Web initViewHolder() {
        return new Web(this, translationService);
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