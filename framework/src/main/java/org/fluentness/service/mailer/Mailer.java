package org.fluentness.service.mailer;

import org.fluentness.service.Service;

import javax.mail.MessagingException;

public interface Mailer extends Service {

    MessageBuilder mail(String... to) throws MessagingException;

    void send(MessageBuilder messageBuilder) throws MessagingException;
}
