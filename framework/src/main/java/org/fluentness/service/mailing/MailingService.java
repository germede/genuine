package org.fluentness.service.mailing;

import org.fluentness.service.Service;

import javax.mail.MessagingException;

public interface MailingService extends Service {

    MessageBuilder mail(String... to) throws MessagingException;

    void send(MessageBuilder messageBuilder) throws MessagingException;
}
