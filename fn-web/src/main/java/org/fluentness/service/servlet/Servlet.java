package org.fluentness.service.servlet;

import org.fluentness.service.Service;
import org.fluentness.service.configuration.Setting;

public interface Servlet extends Service, jakarta.servlet.Servlet {

    Setting<String> RESPONSE_ENCODING = new Setting<>("UTF-8");
    Setting<Boolean> SINGLE_PAGE_MODE = new Setting<>(true);
    Setting<String> AJAX_HANDLER = new Setting<>("<script src=\"/resources/js/ajax-handler.js\"></script>");

}
