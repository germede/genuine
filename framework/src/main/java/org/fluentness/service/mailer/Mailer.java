//package org.fluentness.service.mailer;
//
//import org.fluentness.service.Service;
//import org.fluentness.service.Singleton;
//import org.fluentness.service.configurator.Key;
//
//import javax.mail.MessagingException;
//
//@Singleton
//public interface Mailer extends Service {
//
//    Key<String> mailer_server = new Key<>();
//    Key<String> mailer_username = new Key<>();
//    Key<String> mailer_password = new Key<>();
//    Key<Integer> mailer_port = new Key<>();
//
//    MessageBuilder mail(String... to) throws MessagingException;
//
//    void send(MessageBuilder messageBuilder) throws MessagingException;
//}
