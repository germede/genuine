package org.fluentness.service.mailer;

import org.fluentness.service.Service;
import org.fluentness.service.Singleton;
import org.fluentness.service.configurator.Key;

@Singleton
public interface Mailer extends Service {

    Key<String> SERVER = new Key<>();
    Key<Integer> PORT = new Key<>();
    Key<String> USERNAME = new Key<>();
    Key<String> PASSWORD = new Key<>();

    void send(String from, String to, String message);
}
