package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

import javax.net.ssl.SSLContext;
import java.io.IOException;

public interface Server extends Service {

    Setting<String> HOST = new Setting<>("localhost");
    Setting<Integer> PORT = new Setting<>(8080);
    Setting<String> CONTEXT = new Setting<>("/");
    Setting<SSLContext> SSL_CONTEXT = new Setting<>();

    void start() throws IOException;

    void stop();
}
