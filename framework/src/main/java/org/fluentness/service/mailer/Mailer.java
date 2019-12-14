package org.fluentness.service.mailer;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Mailer extends Service {

    Key<String> SERVER = new Key<>("localhost");
    Key<Integer> PORT = new Key<>(25);

    void send(String from, String to, String message);
}
