package org.fluentness.service.dispatcher;

import org.fluentness.service.AllowMultipleImplementations;
import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

@AllowMultipleImplementations
public interface Dispatcher extends jakarta.servlet.Servlet, Service {

    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/ajax-handler.js\"></script>");

    String getUrlPattern();

}
