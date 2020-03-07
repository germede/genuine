package org.fluentness.service.mailer;

import org.fluentness.service.Service;
import org.fluentness.service.configurator.Setting;

public interface Mailer extends Service {

    Setting<String> SERVER = new Setting<>("localhost");
    Setting<Integer> PORT = new Setting<>(25);

    void send(String from, String to, String message);
}
