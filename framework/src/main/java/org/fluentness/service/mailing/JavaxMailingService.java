package org.fluentness.service.mailing;

import com.sun.mail.smtp.SMTPTransport;
import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logging.LoggingService;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import java.util.Properties;

public class JavaxMailingService implements MailingService {


    private final ConfigurationService configurationService;
    private final LoggingService loggingService;

    public JavaxMailingService(ConfigurationService configurationService, LoggingService loggingService) {
        this.configurationService = configurationService;
        this.loggingService = loggingService;
    }

    @Override
    public MessageBuilder mail(String... to) throws MessagingException {
        Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", String.valueOf(configurationService.getOrDefault(ConfigurationService.mailing_port, 25)));
        Session session = Session.getInstance(prop, null);
        return new MessageBuilder(session, this).to(to);
    }

    @Override
    public void send(MessageBuilder messageBuilder) throws MessagingException {
        try {
            SMTPTransport t = (SMTPTransport) messageBuilder.getSession().getTransport("smtp");
            t.connect(
                configurationService.getOrDefault(ConfigurationService.mailing_server, "localhost"),
                configurationService.getOrDefault(ConfigurationService.mailing_username, ""),
                configurationService.getOrDefault(ConfigurationService.mailing_password, "")
            );
            t.sendMessage(messageBuilder.getMessage(), messageBuilder.getMessage().getAllRecipients());
            t.close();
            loggingService.debug("Mail response: %s", t.getLastServerResponse().replace("\n",""));
        } catch (NoSuchProviderException e) {
            loggingService.error(e);
        }
    }

}
