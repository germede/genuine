package org.fluentness.service.dispatcher;

import org.fluentness.service.MultiService;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

@MultiService
public interface Dispatcher extends jakarta.servlet.Servlet, Service {

    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/javaScript-commands.js\"></script>");

    String getUrlPattern();

}
