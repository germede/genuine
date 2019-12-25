package org.fluentness.service.mailer;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.configuration.Key;

public interface Mailer extends ApplicationComponent {

    Key<String> SERVER = new Key<>("localhost");
    Key<Integer> PORT = new Key<>(25);

    void send(String from, String to, String message);
}
