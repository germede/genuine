//package org.fluentness.service.mailer;
//
//import com.sun.mail.smtp.SMTPTransport;
//import org.fluentness.service.configurator.Configurator;
//import org.fluentness.service.logger.Logger;
//
//import javax.mail.MessagingException;
//import javax.mail.NoSuchProviderException;
//import javax.mail.Session;
//import java.util.Properties;
//
//public class JavaxMailer implements Mailer {
//
//
//    private final Configurator configurator;
//    private final Logger logger;
//
//    public JavaxMailer(Configurator configurator, Logger logger) {
//        this.configurator = configurator;
//        this.logger = logger;
//    }
//
//    @Override
//    public MessageBuilder mail(String... to) throws MessagingException {
//        Properties prop = System.getProperties();
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.port", String.valueOf(configurator.getOrDefault(Mailer.mailer_port, 25)));
//        Session session = Session.getInstance(prop, null);
//        return new MessageBuilder(session, this).to(to);
//    }
//
//    @Override
//    public void send(MessageBuilder messageBuilder) throws MessagingException {
//        try {
//            SMTPTransport t = (SMTPTransport) messageBuilder.getSession().getTransport("smtp");
//            t.connect(
//                configurator.getOrDefault(Mailer.mailer_server, "localhost"),
//                configurator.getOrDefault(Mailer.mailer_username, ""),
//                configurator.getOrDefault(Mailer.mailer_password, "")
//            );
//            t.sendMessage(messageBuilder.getMessage(), messageBuilder.getMessage().getAllRecipients());
//            t.close();
//            logger.debug("Mail response: %s", t.getLastServerResponse().replace("\n",""));
//        } catch (NoSuchProviderException e) {
//            logger.error(e);
//        }
//    }
//
//}
