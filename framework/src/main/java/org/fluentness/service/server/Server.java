package org.fluentness.service.server;

import org.fluentness.service.Service;
import org.fluentness.service.configurator.Setting;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

public interface Server extends Service {

    Setting<String> HOST = new Setting<>("localhost");
    Setting<Integer> PORT = new Setting<>(8080);
    Setting<String> CONTEXT = new Setting<>("/");
    Setting<SSLContext> SSL_CONTEXT = new Setting<>();
    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/ajax-handler.js\"></script>");

    void start(Map<String, Method> routes) throws IOException;

    void stop();
}
