package org.fluentness.service.mail;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Mail extends Service {

    Setting<String> SERVER = new Setting<>("localhost");
    Setting<Integer> PORT = new Setting<>(25);

    void send(String from, String to, String message);
}
