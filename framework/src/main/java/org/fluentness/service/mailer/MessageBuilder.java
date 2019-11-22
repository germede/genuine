package org.fluentness.service.mailer;

import org.fluentness.controller.web.WebView;
import serp.util.Strings;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;

public class MessageBuilder {

    private final Session session;
    private final Message message;
    private final Mailer mailer;

    MessageBuilder(Session session, Mailer mailer) {
        this.session = session;
        this.message = new MimeMessage(session);
        this.mailer = mailer;
    }

    Message getMessage() {
        return message;
    }

    Session getSession() {
        return session;
    }

    public MessageBuilder from(String from) throws MessagingException {
        message.setFrom(new InternetAddress(from));
        return this;
    }

    public MessageBuilder to(String... to) throws MessagingException {
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Strings.join(to, ",")));
        return this;
    }

    public MessageBuilder cc(String... cc) throws MessagingException {
        message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(Strings.join(cc, ",")));
        return this;
    }

    public MessageBuilder bcc(String... bcc) throws MessagingException {
        message.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(Strings.join(bcc, ",")));
        return this;
    }

    public MessageBuilder replyTo(String... replyTo) throws MessagingException {
        message.setReplyTo(InternetAddress.parse(Strings.join(replyTo, ",")));
        return this;
    }

    public MessageBuilder subject(String subject) throws MessagingException {
        message.setSubject(subject);
        return this;
    }

    public MessageBuilder flags(Flags flags, boolean set) throws MessagingException {
        message.setFlags(flags, set);
        return this;
    }

    public MessageBuilder sentDate(Date date) throws MessagingException {
        message.setSentDate(date);
        return this;
    }

    public MessageBuilder content(WebView webView, String... attachments) throws MessagingException {
        DataHandler dataHandler = new DataHandler(new MailingHtmlDataSource(webView.render()));
        if (attachments.length == 0) {
            message.setDataHandler(dataHandler);
        } else {
            MimeBodyPart htmlBodyPart = new MimeBodyPart();
            htmlBodyPart.setDataHandler(dataHandler);
            withAttachments(htmlBodyPart, attachments);
        }
        return this;
    }

    public MessageBuilder content(String content, String... attachments) throws MessagingException {
        if (attachments.length == 0) {
            message.setText(content);
        } else {
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(content);
            withAttachments(textBodyPart, attachments);
        }
        return this;
    }

    private void withAttachments(BodyPart bodyPart, String... attachments) throws MessagingException {
        Multipart multipart = new MimeMultipart();
        for (String filePath : attachments) {
            MimeBodyPart fileBodyPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filePath);
            fileBodyPart.setDataHandler(new DataHandler(fileDataSource));
            fileBodyPart.setFileName(fileDataSource.getName());
            multipart.addBodyPart(fileBodyPart);
        }
        multipart.addBodyPart(bodyPart);
        message.setContent(multipart);
    }

    public void send() throws MessagingException {
        mailer.send(this);

    }
}
